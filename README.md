# spring_cloud_demo
a demonstrator of a cloud-native java application

# Prerequisites
JDK 17

Spring Boot CLI

Maven?

IntelliJ Idea

MySql server

Node.js

<br>
in the MySql console, execute:

mysql> create database scd_greeting; -- Creates the new database
mysql> create database scd_name; -- Creates the new database

mysql> create user 'scd'@'%' identified by 'scd'; -- Creates the user

mysql> grant all on scd_greeting.* to 'scd'@'%'; -- Gives all privileges to the new user on the newly created database
mysql> grant all on scd_name.* to 'scd'@'%'; -- Gives all privileges to the new user on the newly created database

Then run the application a first time in order to hibernate to create the tables, then insert those data:
use scd_greeting;
insert into greeting values (1, 'Hello', '');
insert into greeting values (2, 'Hallo', 'de');
insert into greeting values (3, 'Hola', 'es');
insert into greeting values (4, 'Hello', 'en');
use scd_name;
insert into name values (1, 'Henri');
insert into name values (2, 'Hervé');

