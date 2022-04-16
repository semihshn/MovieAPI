<div align="center">

# Movie Application

<img src="./src/main/resources/images/top.png" width="150">

This project is a movie application demo

---
</div>

## Table of Contents
- [Movie Application](#movie-application)
  - [Table of Contents](#table-of-contents)
  - [How to build](#how-to-build)
  - [Reports](#reports)
    - [Database Diagram](#database-diagram)
    - [Motivation](#motivation)
    - [Technologies Used](#technologies-used)
    - [Author](#author)

---

## How to build

> - Make sure your computer has docker,java17 and maven installed
> - Open your terminal and enter the CreditSystem folder with the cd command
> - Run "mvn clean install -U -DskipTests=true"
> - Run "docker-compose up" 
> - Go to "http://localhost:8080/swagger-ui/index.html#/" from browser
> - Create a new account with /accounts end point
> - Get token by entering the account information you created with /login end point
> - Enter token by pressing the Authorize button on the top right, adding Bearer to the head of the value section
> - And now you can use all the end-pointes :blush:

## Reports
* [Sonar Report](#)

---
<div align="center">

### Database Diagram
[![Database Diagram](./images/db-diagram.GIF)](./images/db-diagram.GIF)

---

### Motivation

I want to write clean, sustainable, well-defined boundary context, well-tested domain code and isolate business logic from external concerns. Hexagonal architecture allows us to become domain software, which is a very comfortable way to change technology because it provides a loosely couple environment without the technical details of the project, and it also prepares our monolith-starting project for micro-servicers


</div>

---

### Technologies Used

Here is the list of technologies I used for the Credit Application System;

* Spring Boot 2
* Java 17
* Docker
* PostgreSql
* Redis(**Used redis at end point /creditapplicationinformations/{identificationnumber}**)
* Custom Exception Handler
* Lombok
* Swagger UI
* Unit/Integration Tests

---

### Author
* **Semih Şahan**, Software Developer -> [Github](https://github.com/semihshn), [Twitter](https://twitter.com/Semih87059904), [Linkedin](https://www.linkedin.com/in/semih%C5%9Fahan/)