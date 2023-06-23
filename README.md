# spring_cloud_demo
a demonstrator of a cloud-native java application

# Prerequisites
JDK 17

Spring Boot CLI

Gradle 7.4

IntelliJ Idea

MySql

<br>
in the MySql console, execute:

mysql> create database scd; -- Creates the new database

mysql> create user 'scd'@'%' identified by 'scd'; -- Creates the user

mysql> grant all on scd.* to 'scd'@'%'; -- Gives all privileges to the new user on the newly created database

