# SEiPAssignments: Assignment 2

## Overview
This is the second lab assignment of the course Software Engineering in Practice.
The specific project offers a Java application that reads a file with students’ grades and generates its histogram.

## Getting Started

### Prerequisites
[Maven](https://maven.apache.org/)
(Instructions on how to install Maven can be found [here](https://maven.apache.org/))

### Installing

Execute the following command in the repository root directory in order to build all modules. 
```
mvn package
```
This command generates a seperate jar file in each module's corresponding target (```module/target```) directory.

### Running 

The produced jar is located in the target directory and can be executed from the root directory as following:

```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <text_file>
```
where ``` <text_file>``` is the file with the grades from which the histogram will be extracted. 
The input file should have the format of the file ```<grades.txt>``` which is located in directory ```gradeshistogram\src\main\resources```
