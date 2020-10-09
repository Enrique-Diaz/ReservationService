# ReservationService
Service for Reservations

Example project of a µReservationService with the following technologies;
* Java 8
* Spring Boot
* Spring Web
* Spring Data
* H2DB
* Swagger2
* Lombok
* JUnit
* Mockito

Service will serve the following petitions;
* Get all reservations

# Things to consider
1. To run this application you need to have git and maven installed in the desired machine to work.
2. Once the project is cloned use mvn clean test spring-boot:run (this will clean the project, run tests and finally run the application).
3. You can test the endpoints by curl, postman/soapui or with swagger (http://localhost:8080/swagger-ui.html).
4. It's possible to see the DB at http://localhost:8080/h2-console (user:sa | no password set)
