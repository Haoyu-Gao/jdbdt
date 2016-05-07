package org.jdbdt;

/**
 * Database delta.
 * 
 * @since 0.1
 * 
 */
final class DBAssert {
  /**
   * Perform a delta assertion.
   * 
   * <p>
   * Delta assertion methods in the {@link JDBDT} delegate the
   * actual verification to this method.
   * </p>
   * 
   * @param callInfo Call info.
   * @param oldData Old data expected.
   * @param newData New data expected.
   * @throws DBAssertionError If the assertion fails.
   * @throws InvalidOperationException If the arguments are invalid. 
   */
  static void deltaAssertion(CallInfo callInfo, DataSet oldData, DataSet newData) {
    validateDeltaAssertion(oldData, newData);
    final DataSource source = oldData.getSource();
    final DB db = source.getDB();
    final DataSet snapshot = source.getSnapshot();
    final DataSet stateNow = source.executeQuery(callInfo, false);
    final Delta dbDelta = new Delta(snapshot, stateNow);
    final Delta oldDataMatch 
      = new Delta(oldData.getRows().iterator(), dbDelta.deleted());
    final Delta newDataMatch 
      = new Delta(newData.getRows().iterator(), dbDelta.inserted());
    final DeltaAssertion da = 
      new DeltaAssertion(oldData, newData, oldDataMatch, newDataMatch);
    db.log(callInfo, da);
    if (!da.passed()) {
      throw new DBAssertionError(callInfo.getMessage());
    }
  }
  
  @SuppressWarnings("javadoc")
  private static void
  validateDeltaAssertion(DataSet oldData, DataSet newData) {
    if (oldData == null) {
      throw new InvalidOperationException("Null argument for 'old' data set.");
    }
    if (newData == null) {
      throw new InvalidOperationException("Null argument for 'new' data set.");
    }
    if (oldData.getSource() != newData.getSource()) {
      throw new InvalidOperationException("Data source mismatch between data sets.");
    }
    if (oldData.getSource().getSnapshot() == null) {
      throw new InvalidOperationException("Undefined snapshot for data source.");
    } 
  }
  
  /**
   * Perform a state assertion.
   * 
   * <p>
   * State assertion methods in the {@link JDBDT} delegate the
   * actual verification to this method.
   * </p>
   * 
   * @param callInfo Call info.
   * @param expected Expected data.
   * @throws DBAssertionError If the assertion fails.
   * @throws InvalidOperationException If the arguments are invalid. 
   */
  static void stateAssertion(CallInfo callInfo, DataSet expected) {
    if (expected == null) {
      throw new InvalidOperationException("Null data set.");
    }
    final DataSource source = expected.getSource();
    final DataSet stateNow = source.executeQuery(callInfo, false);
    final Delta delta = new Delta(expected, stateNow); 
    final StateAssertion sa = 
      new StateAssertion(expected, delta);
    source.getDB().log(callInfo, sa);
    if (! sa.passed()) {
      throw new DBAssertionError(callInfo.getMessage());
    }
  }
  
  

  /**
   * Private constructor, to prevent instantiation.
   */
  private DBAssert() {
    
  }

  
}
