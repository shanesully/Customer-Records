
# Customer-Records

## Description

This is a simple Spring Boot Java application that parses a JSON list of those customer records and outputs a list of customers within 100 kilometers of a known geo coordinate and sorts them by their 'user_id' field in ascending order.

### Implementation Details
* Easily-runnable Spring Boot application bootstrapped using Spring Initializr
* Application properties are configurable via YAML file
* Idiomatic Spring and Java code using
* JUnit integration
* Gradle application with easy dependency management
* Easily extensible following industry-standard technologies
* Calculations using standard Math libraries
* SCM using git and GitHub
* gitignore file to keep commits junk-free
* MIT license

### Technologies Used
* Java 8
* Spring
* Spring Boot
* Spring Initializr
* git

### Dependencies Used
* Hamcrest
* Jackson(ObjectMapper for parsing)

### Future Areas of Improvements
* Make the properties configurable via command-line arguments and/or a GUI
* Improve application architecture following an industry-standard design pattern
* Improve test coverage and application robustness
* Use multiple branches for SCM(define branching strategy)
* Adopt a code style(e.g. Google Java Style Guide)
* Implement SLF4J logging
* Implement bare-bones CI/CD pipeline(Jenkins, SonarQube, etc)
* Configure mocking for tests
* Implement validation services at controller-level
* Make port easily configurable

## Build and Run The Application
* Run the 'Application' class under your development environment  of choice(e.g. IntelliJ)
* Navigate to 'http://localhost:8080' in your web browser of choice

## Run Tests
*  Run the 'ApplicationTests' class under your development environment  of choice(e.g. IntelliJ)
