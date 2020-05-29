# SEiPAssignments: Assignment 4
[![Build Status](https://travis-ci.com/MariaGkoulta/SEiPAssignments.svg?token=KpHRL7BnsX1xF4zhpsMT&branch=master)](https://travis-ci.com/MariaGkoulta/SEiPAssignments)
[![Build Status](https://travis-ci.com/MariaGkoulta/SEiPAssignments.svg?token=KpHRL7BnsX1xF4zhpsMT&branch=development)](https://travis-ci.com/MariaGkoulta/SEiPAssignments)

## Overview
This is the fourth lab assignment of the course Software Engineering in Practice. Its goal is to get familiar with design principles by refactoring code and applying design patterns on a given code base.
For this assignment we have to act as the maintainers of a software system that reads a Java source code file that is stored locally or on the web, calculates the LOC, NOM and NOC metrics and finally, exports these metrics to an output file
The new module which is added for this purpose is called ```sourcecodeanalyzer```

## Getting Started

### Prerequisites
- Java JDK [version 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later)
- Maven [3.3](https://maven.apache.org/)
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

## Generate Test-coverage report
To simply run the unit tests of the project, execute the following Maven command:
```
mvn test jacoco:report
```




### Prerequisites
- Java JDK [version 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later)
- Maven [3.3](https://maven.apache.org/)
(Instructions on how to install Maven can be found [here](https://maven.apache.org/))

### Installing
#### Step 1:
Execute the following command in the repository root directory in order to build all modules.
```
mvn package jacoco:report
```
#### Step 2:
Execute the following command in order to run the program
```
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
	were args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
```
For example:
```
	java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

### Design Decisions
#### LocationReader – LocationReaderFactory
To implement the function of reading a file from a specific location and then insert it in a specific type of structure,
the design principle of Factory on Strategy has been used. Specifically, an abstract class named LocationReader was created
that contains the methods readBufferIntoList and readBufferIntoString which accept as parameter a buffered reader and return
a list of strings or a string respectively. The abstract methods that have to be implemented by the sub-classes are the
readIntoList and readIntoString methods. The classes that extend the LocationReader class are the WebFileReader and LocalFileReader.
Those classes have as a private field the buffered reader used by the above methods to read the file into a String or a List.
Moreover, a class named LocationReaderFactory was created in order to produce the correct LocationReader according to the source
file location type. Right now, the locations supported are a local file and a file in the web. By implementing the function as
described above, it is easy to add a new location and create the respective buffer in order to call the methods readIntoString and
readIntoList.
#### Metric
The interface Metric was created in order to make it easier to add new types of metrics in the system. Each metric has to implement
the methods getPattern() (in order to obtain the pattern which has to be matched in order check how many cases were found which we
have add or substract to get the number which corresponds to the metric), evaluateLine() (in order to check if a line has to be counted
as valid or invalid for the specific metric), getName() (in order to obtain the name of the metric), and substractFromTotal() (which is
the method that defines if the above cases are the metric itself or if they are the invalid cases, and thus, have to be subtracted from
the total code metric).
#### AnalyzerType – AnalyzerTypeFactory
This is one more case where the Factory on Strategy pattern was applied. The types of analyzers currently supported are the regular
expressions (RegexAnalyzer) and the string comparison (StrcompAnalyzer). The analyzer type is represented as an interface and the
subclasses have to implement the method of calculate which receives as parameter a specific metric and calculates it according to
the analyzer type since both classes override this method. My using the strategy pattern it is easier to add new analyzer types and
define the method with which they calculate each metric.
#### AnalyzerType – LocationReader
However, in order to calculate the metric the analyzer type should have the correct form of source code. Therefore the Bridge Pattern
is used in order to assign the correct source code according to the location reader. For example, if the analyzer is of type regex
the source code has to be given as a string. This is achieved by calling the method readIntoString which is defined for every source location type.
#### MetricsWriter – MetricsWriterFactory
The design principle of Factory on Strategy was used for this function as well. Every metrics writer has to implement the method writeFile
and the factory class produces the correct writer according to the input given by the client. With this implementation it’s easy to add new
types of metric writers by only implementing the writeFile method.
#### MetricsCalculator
The MetricsCalculator class serves as a class which gathers all the types of metrics, defines the analyzerType needed, according to the client’s
input, and finally, calculates and exports the metrics.

### Benefits
With this implementation, we make this system more extensible as new types of locations, analyzers, writers and metrics can be added.
We have avoided some duplicate code of the previous version and most of the implementation and instantiation details are hidden from the client.

### Class diagram
The class diagram for the above system can be found [here](class_diagram.png).
