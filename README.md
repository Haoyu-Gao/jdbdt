[![JDBDT](https://raw.githubusercontent.com/JDBDT/jdbdt/master/src/site/resources/images/jdbdt-logo.png)](http://jdbdt.github.io)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](http://jdbdt.github.io/MIT_License.html)
[![Maven Central](https://img.shields.io/maven-central/v/org.jdbdt/jdbdt.svg)](https://search.maven.org/#search%7Cga%7C1%7Corg.jdbdt)
[![GitHub release](https://img.shields.io/github/release/JDBDT/jdbdt.svg)](https://github.com/JDBDT/jdbdt/releases)
[![Travis build Status](https://api.travis-ci.org/JDBDT/jdbdt.png?branch=master)](https://travis-ci.org/JDBDT/jdbdt)
[![AppVeyor build status](https://ci.appveyor.com/api/projects/status/647d281hp1b8py3p?svg=false)](https://ci.appveyor.com/project/edrdo/jdbdt)

## Project Overview

JDBDT (Java Database Testing) is a lightweight library for database testing, designed to simplify the testing of database-related functionality in Java applications.

Visit [http://jdbdt.github.io](http://jdbdt.github.io) for reference.

# Releases

JDBDT releases are available from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cjdbdt) and [GitHub](https://github.com/JDBDT/jdbdt/releases).

## Prerequisites
- Java Development Kit (JDK) version 8 or later.
- Apache Maven for dependency management.

## Installation
1. Clone the repository using Git:
   ```bash
   git clone https://github.com/JDBDT/jdbdt.git
   ```
2. Navigate to the project directory:
   ```bash
   cd jdbdt
   ```
3. Build the project using Maven:
   ```bash
   mvn install
   ```
   
## Usage
Refer to the [official documentation](http://jdbdt.github.io) for usage instructions and examples.


## Change Log
  
Please refer to the [Change Log](CHANGELOG.md) for details
### 1.4.x

Features:
- [#68 - Improved CSV support](https://github.com/JDBDT/jdbdt/issues/68)
- [#72 - CSV custom conversions per JDBC type](https://github.com/JDBDT/jdbdt/issues/72) (1.4.1)

Bug fixes:
- [#71 - CSV bug fix for JDBC types mapped to BigDecimal](https://github.com/JDBDT/jdbdt/issues/71) (1.4.1)

Maintenance:
- Standard maintenance tasks (dependency updates, minor adjustments, etc) 
	* [#69 - 1.4.1](https://github.com/JDBDT/jdbdt/issues/69)

## License

JDBDT is open-source software under the terms of the 
[MIT License](http://jdbdt.github.io/MIT_License.html).

Versions prior to 0.12 were released under the terms of the [Eclipse Public License v 1.0](http://www.eclipse.org/legal/epl-v10.html).

