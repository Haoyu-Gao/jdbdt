[![JDBDT](https://raw.githubusercontent.com/JDBDT/jdbdt/master/src/site/resources/images/jdbdt-logo.png)](http://jdbdt.github.io)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](http://jdbdt.github.io/MIT_License.html)
[![Maven Central](https://img.shields.io/maven-central/v/org.jdbdt/jdbdt.svg)](https://search.maven.org/#search%7Cga%7C1%7Corg.jdbdt)
[![GitHub release](https://img.shields.io/github/release/JDBDT/jdbdt.svg)](https://github.com/JDBDT/jdbdt/releases)
[![Travis build Status](https://api.travis-ci.org/JDBDT/jdbdt.png?branch=master)](https://travis-ci.org/JDBDT/jdbdt)
[![AppVeyor build status](https://ci.appveyor.com/api/projects/status/647d281hp1b8py3p?svg=false)](https://ci.appveyor.com/project/edrdo/jdbdt)


JDBDT (Java Database Delta Testing) is a library for database test automation.

Visit [http://jdbdt.github.io](http://jdbdt.github.io) for reference.

# License

JDBDT is open-source software under the terms of the 
[MIT License](http://jdbdt.github.io/MIT_License.html).

Versions prior to 0.12 were released under the terms of the [Eclipse Public License v 1.0](http://www.eclipse.org/legal/epl-v10.html).

# Releases

JDBDT releases are available from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cjdbdt) and [GitHub](https://github.com/JDBDT/jdbdt/releases).

# Dependencies

JDBDT is self-contained (it uses the Java 8 SE API only).

# Compilation 

Requirements:

* Maven 3.0 or higher
* Java 8 compiler or higher

Commands: 

        git clone git@github.com:JDBDT/jdbdt.git
        cd jdbdt
        mvn install

# Change Log


## 1.4.x

Features:
- [#68 - Improved CSV support](https://github.com/JDBDT/jdbdt/issues/68)
- [#72 - CSV custom conversions per JDBC type](https://github.com/JDBDT/jdbdt/issues/72) (1.4.1)

Bug fixes:
- [#71 - CSV bug fix for JDBC types mapped to BigDecimal](https://github.com/JDBDT/jdbdt/issues/71) (1.4.1)

Maintenance:
- Standard maintenance tasks (dependency updates, minor adjustments, etc) 
	* [#69 - 1.4.1](https://github.com/JDBDT/jdbdt/issues/69)
  
## 1.3.x

Features:

- [#61 - CSV data set import / export](https://github.com/JDBDT/jdbdt/issues/61)
- [#60 - getAutocommit() / setAutoCommit() convenience methods](https://github.com/JDBDT/jdbdt/issues/60)
- [#56 - LIMIT support for QueryBuilder](https://github.com/JDBDT/jdbdt/issues/56)

## 1.2.x 

Features:
* [#47 - JDBDT.database() variants using javax.sql.DataSource](https://github.com/JDBDT/jdbdt/issues/47)
* [#52 - Var-args method variants in JDBDT facade](https://github.com/JDBDT/jdbdt/issues/52)

Maintenance:
* Standard maintenance tasks (dependency updates, minor adjustments, etc) 
	* [#51 - 1.2.0](https://github.com/JDBDT/jdbdt/issues/51)
	* [#53 - 1.2.1](https://github.com/JDBDT/jdbdt/issues/53)
	* [#54 - 1.2.2](https://github.com/JDBDT/jdbdt/issues/54)
	* [#55 - 1.2.3](https://github.com/JDBDT/jdbdt/issues/55)
	* [#59 - 1.2.4](https://github.com/JDBDT/jdbdt/issues/59)

## 1.1.x

Features:

* [#5 - Database exception logging](https://github.com/JDBDT/jdbdt/issues/5)
* [#33 - SQL statement execution through JDBDT.execute](https://github.com/JDBDT/jdbdt/issues/33)
* [#42 - Partial support for case-sensitive column names](https://github.com/JDBDT/jdbdt/issues/42)
* [#43 - DataSet.toString() utility method](https://github.com/JDBDT/jdbdt/issues/43)

Maintenance:

* Standard maintenance tasks (dependency updates, minor adjustments, etc) 
	* [#41 - 1.1.0](https://github.com/JDBDT/jdbdt/issues/41)
	* [#44 - 1.1.1](https://github.com/JDBDT/jdbdt/issues/44)
	* [#45 - 1.1.2](https://github.com/JDBDT/jdbdt/issues/45)
  
## 1.0.x

API:

* [#21 - Data sets can now be used for table updates/deletes.](https://github.com/JDBDT/jdbdt/issues/21)
* [#25 - DataSource.getColumns() now available.](https://github.com/JDBDT/jdbdt/issues/25)

Continuous integration:

* [#18 - Now using AppVeyor for Windows builds](https://github.com/JDBDT/jdbdt/issues/18)
* [#19 - Travis CI: also MacOS builds](https://github.com/JDBDT/jdbdt/issues/19)
* [#20 - Travis CI: also Java 9 builds ](https://github.com/JDBDT/jdbdt/issues/20)
* [#22 - Travis CI: using mysql service if available](https://github.com/JDBDT/jdbdt/issues/22)
* [#23 - Travis CI: using postgresql service if available](https://github.com/JDBDT/jdbdt/issues/23)
* [#24 - Travis CI: SonarQube add-on only for standard Linux build](https://github.com/JDBDT/jdbdt/issues/24)
* [#28 - Fixed broken Java 9 build (1.0.1)](https://github.com/JDBDT/jdbdt/issues/28) 
* [#29 - Coverity scan during Travis build (1.0.1)](https://github.com/JDBDT/jdbdt/issues/29)

Site:
* [#26 - Fixed anchor link location in web pages](https://github.com/JDBDT/jdbdt/issues/26)
* [#27 - Start page is now a bit more appealing](https://github.com/JDBDT/jdbdt/issues/27)

Maintenance:
* [#30 - Stopped using thread-local data (1.0.1)](https://github.com/JDBDT/jdbdt/issues/30)
* [#36 - Transferred ownership to JDBDT organisation (1.0.5)](https://github.com/JDBDT/jdbdt/issues/36)
* Standard maintenance tasks (dependency updates, minor adjustments, etc) 
	* [#31 - 1.0.2](https://github.com/JDBDT/jdbdt/issues/31)
	* [#32 - 1.0.3](https://github.com/JDBDT/jdbdt/issues/32)
	* [#34 - 1.0.4](https://github.com/JDBDT/jdbdt/issues/34)
	* [#35 - 1.0.5](https://github.com/JDBDT/jdbdt/issues/35)
	* [#38 - 1.0.6](https://github.com/JDBDT/jdbdt/issues/38)
	* [#39 - 1.0.7](https://github.com/JDBDT/jdbdt/issues/39)
	* [#40 - 1.0.8](https://github.com/JDBDT/jdbdt/issues/40)

## 0.12

Slight API adjustments:
* [#9 - API cleanup](https://github.com/JDBDT/jdbdt/issues/9)
* [#15 - Let assertTableExists/DoesNotExist take the table name as argument](https://github.com/JDBDT/jdbdt/issues/15)
* [#16 - Variant of drop operation supplying database handle and table name](https://github.com/JDBDT/jdbdt/issues/16)

Maintenance:
* [#13 - Missing reference documentation in site for table dropping / table existence assertions](https://github.com/JDBDT/jdbdt/issues/13)
* [#14 - Start using MIT license from 0.12 onwards](https://github.com/JDBDT/jdbdt/issues/14)

## 0.11

Features:
* [#4 - Support for table dropping / table existence assertions](https://github.com/JDBDT/jdbdt/issues/4)
* [#10 - Support for compressed log files (GZIP)](https://github.com/JDBDT/jdbdt/issues/10)

Maintenance:
* [#6 - SonarQube integration during Travis build](https://github.com/JDBDT/jdbdt/issues/6)
* [#7 - Adapt PostgreSQL test code (postgresql-embedded 2.x version features)](https://github.com/JDBDT/jdbdt/issues/7)
* [#8 - Let Travis cache Maven repository](https://github.com/JDBDT/jdbdt/issues/8)
* [#11 - Optionally run PIT mutation tests](https://github.com/JDBDT/jdbdt/issues/11)

## 0.10

* [#3: ColumnFillerException should also extend JDBDTRuntimeException](https://github.com/JDBDT/jdbdt/issues/2)
* Misc. maintenance / refactoring / handling of SonarQube issues

## 0.9

* [#2 - DataSource.setSnapshot() clears the contents of previous snapshot set](https://github.com/JDBDT/jdbdt/issues/2)
* Exception hiearchy revised: `JDBDTRuntimeException` now base class
for runtime exceptions, new `UnsupportedOperationException` and `InternalErrorException` classes.
* Misc. documentation/site adjustments.

## 0.8

* Builder pattern now more properly used for tables (`TableBuilder`).
* Improved handling of database errors.

## 0.7

* Database insertions now done in batch mode.
* Validation of savepoint support.
* Miscellaneous maintenance (code style, Javadoc, site).

## 0.6

* `populateIfChanged`, `changed`: new facade methods.
* Improved handling of reusable/non-reusable statements.
* Documentation adjustments.

## 0.5

* `DataSetBuilder`: inhibit re-seeding of PRNG, and compute PRNG seed from
data source columns.
* Small adjustements to web site.
* Other small adjustments.

## 0.4

* Logging improvements.

## 0.3 

* Bug fixes & improvements when handling array data (e.g. BINARY) from/to database.
* A few documentation improvements.

## 0.2 

* `DataSet`: `head` and `tail` methods respectively renamed to `first` and `last`.
* `ColumnFillerException` introduced to signal errors during column filler execution.
* Documentation improvements (site pages and Javadoc).

## 0.1

Initial release.


