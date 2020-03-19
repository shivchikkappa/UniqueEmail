# Problem statement 

Accept a list of email addresses and return an integer indicating the number of unique email addresses. 
Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. 
Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".

Examples:
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.

# Technologies
JDK 1.8.0

Springboot 2.2.5

Maven 3.6.1

Git 2.14.1

Swagger 2.9.2

# Build, Run and test application
Clone the repo from github

mvn clean install

java -jar target/assignment-0.0.1-SNAPSHOT.jar

Application will start running on port 9080

Application admin port is configured on port 9085

# API documentation

API documenation is enabled using swagger which can be accessed at http://localhost:9080/swagger-ui.html#/ 

# Springboot metrics using actuator
Springboot admin is configured to run on port 9085. 

Access http://localhost:9085/actuator to access all the management end points

Simple HealthCheck is implemented at http://localhost:9085/actuator/health to veriy application is running

# FYI

DTO objects are not necessary for this problem but are added to show the request and respone objects handling and swagger documentation.

# TODO

Add Resource and Service layer Junit test cases

Implement Security for Rest API access

Implement SpingbootAdmin and register the application for monitoring.


