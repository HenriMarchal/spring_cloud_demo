# What is this 01 module?
It's the application before having been 'cloudified'.
A quite standard Spring Boot application with a GUI (React), some microservices and a database (Hibernate+mySQL).
It will be our base upon we will apply a lot of Spring Cloud features.

Understand that is classic in the sense where it is designed to be deployed in an application server.
It is possible to deploy it in a cloud environment but then it requires a lot of ugly tricks and a constant maintenance of its configuration (because a cloud is always evolving).

And I've chosen the microservices design pattern because it is quite interesting to play with it in a cloud environment, and to see how far we can stress it.