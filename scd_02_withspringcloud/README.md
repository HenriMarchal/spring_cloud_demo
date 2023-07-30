# What is this 02 module?

Same as scd_01 but the Java projects are executed in a cloud environment.

In order to do so, please, install k3s and docker

The projects are the same but there are three Dockerfile for the microservices. And the config for k3s

<br>

# k3s post-install

create this secret for dockerhub

kubectl create secret docker-registry regcred --docker-server=<your-registry-server> --docker-username=<your-name> --docker-password=<your-pword> --docker-email=<your-email>

You must create a client user, then to connect with this user, then to create the node of the application.

# Run the application

on each Java project (greeting, name and web), launch at the root of the project: "./mvnw compile" and then "./mvn spring-boot:run".

Finally, launch the React frontend: go the root of the frontend project. Launch "npm install", then "npm start".

In the upper screen, you can test the greeting service. And at the bottom, you can test the load whole services. This part makes in evidence the need of a load balancer with automatically popping new servers as it will be in the cloud.
