package org.jdbdt;


import static org.jdbdt.JDBDT.*;

import java.sql.SQLException;
import java.util.EnumMap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@SuppressWarnings("javadoc")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueryTest extends DBTestCase { 
  enum S {
    ARGS, COLS, GROUP_BY, HAVING, ORDER_BY, WHERE;
  }
  interface QMutator<T> {
    Query set(T arg);
  }
  private Query theSUT;
  private EnumMap<S,Object> qsetup;
 
  @Before
  public void createQuery() throws SQLException {
    Table t = table(UserDAO.TABLE_NAME)
             .columns(UserDAO.COLUMNS)
             .boundTo(getConnection());
    theSUT = selectFrom(t);
    qsetup = new EnumMap<>(S.class);
    for (S s : S.values()) {
      qsetup.put(s, null);
    }
    qsetup.put(S.COLS, UserDAO.COLUMNS);
  }
  
  <T> void qset(S s, QMutator<T> m, T arg) {
    qsetup.put(s, arg);
    assertSame(theSUT, m.set(arg));
  }

  void qverify() {
    assertEquals(qsetup.get(S.WHERE),    theSUT.whereClause());
    assertEquals(qsetup.get(S.HAVING),   theSUT.havingClause());
    assertArrayEquals((String[]) qsetup.get(S.GROUP_BY), s2a(theSUT.groupByClause()));
    assertArrayEquals((String[]) qsetup.get(S.ORDER_BY), s2a(theSUT.orderByClause()));
    assertArrayEquals((Object[]) qsetup.get(S.ARGS), theSUT.getQueryArguments());
    assertArrayEquals((String[]) qsetup.get(S.COLS), theSUT.getColumnNames());
  }
  
  static String[] s2a(String s) {
    return s == null ? null : s.split(",");
  }
  
  @Test
  public void testInit() {
    qverify();
  }
  
  @Test
  public void testInitWhere() {
    qset(S.WHERE, theSUT::where, "login='foo'");
    qverify();
  }
  
  @Test
  public void testInitOrderBy1() {
    qset(S.ORDER_BY, theSUT::orderBy, new String[] { "login" });
    qverify();
  }
  
  @Test
  public void testInitOrderBy2() {
    qset(S.ORDER_BY, theSUT::orderBy, new String[] { "password", "login" });
    qverify();
  }
  
  
  @Test
  public void testInitGroupBy1() {
    qset(S.GROUP_BY, theSUT::groupBy, new String[] { "password" });
    qverify();
  }
  
  @Test
  public void testInitGroupBy2() {
    // TODO sensible query
    qset(S.GROUP_BY, theSUT::groupBy, new String[] { "password", "login" });
    qverify();
  }
  
  @Test
  public void testInitHaving() {
    // TODO sensible query
    qset(S.HAVING, theSUT::having, "created NOT NULL");
    qverify();
  }
  @Test
  public void testInitQueryArguments() {
    qset(S.ARGS, theSUT::withArguments, new Object[] { "foo", 1 });
    qverify();
  }
  
  @Test
  public void testInitChain1() {
    qset(S.WHERE, theSUT::where, "login LIKE '%user%'");
    qset(S.ORDER_BY, theSUT::orderBy, new String[] { "login" });
    qverify();
  }
  
  
  @Test
  public void testInitChain2() {
    // TODO sensible query
    qset(S.WHERE, theSUT::where, "login LIKE ?");
    qset(S.ARGS, theSUT::withArguments, new Object[] { "foo%" });
    qset(S.ORDER_BY, theSUT::orderBy, new String[] { "login" });
    qset(S.HAVING, theSUT::having, "created NOT NULL");
    qverify();
  }
  
  void initTwice(QMutator<String> m) {
    m.set("1");
    try {
      m.set("2");
      fail(InvalidUsageException.class.toString());
    } 
    catch(InvalidUsageException e) { }
  }
  
  @Test 
  public void testInitWhereTwice() { 
    initTwice(theSUT::where); 
  }
  @Test 
  public void testInitGroupByTwice() {
    initTwice(theSUT::groupBy);
  }
  @Test 
  public void testInitOrderByTwice() {
    initTwice(theSUT::orderBy);
  }
  @Test 
  public void testInitHavingTwice() {
    initTwice(theSUT::having);
  }
  @Test 
  public void testInitArgumentsTwice() {
    initTwice(theSUT::withArguments);
  }
  @Test 
  public void testInitColumnsTwice() {
    initTwice(theSUT::columns);
  }
  
  void initAfterCompiling(QMutator<String> m) {
    theSUT.getQueryStatement();
    try {
      m.set("x");
      fail(InvalidUsageException.class.toString());
    } 
    catch(InvalidUsageException e) { }
  }
  
  @Test 
  public void testInitWhereAfterCompiling() { 
    initAfterCompiling(theSUT::where); 
  }
  @Test 
  public void testInitGroupByAfterCompiling() {
    initAfterCompiling(theSUT::groupBy);
  }
  @Test 
  public void testInitOrderByAfterCompiling() {
    initAfterCompiling(theSUT::orderBy);
  }
  @Test 
  public void testInitHavingAfterCompiling() {
    initAfterCompiling(theSUT::having);
  }
  @Test 
  public void testInitArgumentsAfterCompiling() {
    initAfterCompiling(theSUT::withArguments);
  }
  @Test 
  public void testInitColumnsAfterCompiling() {
    initAfterCompiling(theSUT::columns);
  }
  
  void matchDataSets(DataSet expected, DataSet actual) {
    actual.enforceHOrdering();
    expected.enforceHOrdering();
    assertEquals(actual, expected);
  }
  @Test
  public void testExecPlain() {
    DataSet actual = theSUT.executeQuery(false);
    DataSet expected = 
      data(theSUT, getConversion())
        .rows(INITIAL_DATA);
    matchDataSets(actual, expected);
  }
  
  @Test
  public void testExecWithOrderBy1() {
    DataSet actual = theSUT
                    .orderBy("login")
                    .executeQuery(false);
    DataSet expected = 
        data(theSUT, getConversion())
        .rows(INITIAL_DATA);
    matchDataSets(actual, expected);
  }
  
  @Test
  public void testExecWithOrderBy2() {
    DataSet actual = theSUT
                    .orderBy("login", "password")
                    .executeQuery(false);
    DataSet expected = 
        data(theSUT, getConversion())
        .rows(INITIAL_DATA);
    matchDataSets(actual, expected);
  }
  
  @Test
  public void testExecWhere() throws SQLException {
    User u = getDAO().query(EXISTING_DATA_ID1);
    DataSet actual = theSUT
                    .where("login='" + EXISTING_DATA_ID1 + "'")
                    .executeQuery(false);
    DataSet expected = 
        data(theSUT, getConversion())
          .row(u);
    matchDataSets(actual, expected);
  }
  
  @Test
  public void testExecWhereWithArgs() throws SQLException {
    User u = getDAO().query(EXISTING_DATA_ID1);
    assertNotNull(u);
    DataSet actual = theSUT
                    .where("login=?")
                    .withArguments(EXISTING_DATA_ID1)
                    .executeQuery(false);
    DataSet expected = 
        data(theSUT, getConversion())
          .row(u);
    matchDataSets(actual, expected);
  }
}