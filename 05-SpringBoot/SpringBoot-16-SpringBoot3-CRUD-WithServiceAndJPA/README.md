# Spring Boot 3 API REST CRUD with Service And Repository using JPA

A spring boot 3 API REST CRUD implemented (business logic implemented in service, database in memory using a Repository with JPA))

## 1. Go to H2 console

Go to this url

http://localhost:8080/h2-console/

Put the JDBC URL, name and password set in application.yml

## 2. Problem

With this implementation, the CarRepository is coupled to JPA. In hexagonal architecture we need to decouple this.

