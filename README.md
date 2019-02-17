# BambooProject

This project is a maven project. It has been made using Spring MVC, Hibernate, Thymeleaf & MySQL.

To run the project you will need to create schema in MySQL called 'bamboodb', with the following user credientials:

Username: bambino
Password: !ImInside!

(* Note that these credentials can be changed in the application.properties file. *)


Assumptions made:
Usernames are unique for each user

How to run the proejct:

Using terminal (must have mvn installed):
Navigate to the folder then issue the following command:
mvn clean install && mvn spring-boot:run

Eclipse ( must have Spring Tools Suite installed )
Import the project into eclipse
Run maven clean install
Run the project as a Spring boot app 
