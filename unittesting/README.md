# SEiPAssignments: Assignment 3
[![Build Status](https://travis-ci.com/MariaGkoulta/SEiPAssignments.svg?token=KpHRL7BnsX1xF4zhpsMT&branch=development)](https://travis-ci.com/MariaGkoulta/SEiPAssignments)

## Overview
This is the third lab assignment of the course Software Engineering in Practice.
The specific project consists of test cases for classes that contain some methods for arithmetic operations and file reading.

## Getting Started

### Prerequisites
- Java JDK [version 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later)
- [Maven 3.3] (https://maven.apache.org/)
(Instructions on how to install Maven can be found [here](https://maven.apache.org/))

### Installing
Execute the following command in the repository root directory in order to build all modules. 
```
mvn clean install jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

## Test project
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test
```

## Generate Test-coverage report
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test jacoco:report
```