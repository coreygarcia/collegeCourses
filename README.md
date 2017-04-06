*****************************************************************************
* Simple programming assignments for the management for college courses
* Data mode to support the management of students, instructors, and courses
* RESTful APIs for CRUD operations
*****************************************************************************



************* Spring Boot Application w/ following dependencies *************
* JPA
* REST
* H2



**************************** Building and Running ***************************
* Use gradle wrapper to build the project
* Example:
* open a terminal
* navigate to your workspace
* $ cd collegeCourses/
* $ ./gradlew build

* Run the app
* Example:
* $ java -jar build/libs/collegeCourses-0.0.1-SNAPSHOT.jar

* Navigate to an endpoint to make sure it is running
* Example:
* GET http://localhost:8080/instructor/
* GET http://localhost:8080/student/
* GET http://localhost:8080/course/

* Note: tests are ran when you perform the above build ($ ./gradlew build)
* Can also view results in collegeCourses/build/reports/tests/test/index.html



********************** Example: Creating an Instructor ***********************

*** Verb and Endpoint ***
POST http://localhost:8080/instructor/

*** Raw Headers ***
Accept: application/json
Content-type: application/json

*** Raw Payload ***
{
"firstName": "Matt",
"lastName": "Damon",
"age": 31,
"gender": "MALE",
"memberType": "INSTRUCTOR"
}



************************ Example: List all Instructors *********************** 

*** Verb and Endpoint ***
GET http://localhost:8080/instructor/



************************ Example: Updating a Student ************************* 

*** Verb and Endpoint ***
PUT http://localhost:8080/student/

*** Raw Headers  ***
Accept: application/json
Content-type: application/json

*** Raw Payload ***
{
"id", 1,
"firstName": "Tom",
"lastName": "Hanks",
"age": 21,
"gender": "MALE",
"memberType": "STUDENT"
}



************************ Example: Get Student by Id *********************** 

*** Verb and Endpoint ***
GET http://localhost:8080/student/1



************************* Example: Deleting a Course ************************* 

*** Verb and Endpoint ***
DELETE http://localhost:8080/course/1

*** Raw Headers  ***
Accept: application/json
Content-type: application/json
