# spring_cloud_demo
a demonstrator of a cloud-native java application

# Prerequisites
JDK 1.8

Spring Boot CLI

Maven

IntelliJ Idea

MySql server

<br>
in the MySql console, execute:

mysql> create database scd_greeting; -- Creates the new database

mysql> create user 'scd_greeting'@'%' identified by 'scd'; -- Creates the user

mysql> grant all on scd_greeting.* to 'scd'@'%'; -- Gives all privileges to the new user on the newly created database

