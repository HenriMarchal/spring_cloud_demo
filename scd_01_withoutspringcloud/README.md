# What is this 01 module?
It's the application before having been 'cloudified'.

A quite standard Spring Boot application with a GUI (React), some microservices and a database (JPA+mySQL).

It will be our base upon we will apply a lot of Spring Cloud features.

<br>
Understand that is classic in the sense where it is designed to be deployed in an application server.

It is possible to deploy it in a cloud environment but then it requires a lot of ugly tricks and a constant maintenance of its configuration (because a cloud is always evolving).

<br>
And I've chosen the microservices design pattern because it is quite interesting to play with it in a cloud environment, and to see how far we can stress it.

For more pleasure, I also implemented the database per service pattern.

<br>
This Spring Boot application has quite been inspired by this free OpenClassRooms tutorial: https://openclassrooms.com/fr/courses/4668056-construisez-des-microservices

I encourage you to read it in order to get details about this scd_01_withoutspring app.

I have also used this paid Udemy course: https://www.udemy.com/course/microservices-software-architecture-patterns-and-techniques/learn/lecture/10513302#overview


