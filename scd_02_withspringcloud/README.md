# What is this 02 module?

Same as scd_01 but the Java projects are executed in a sping cloud environment.

# Run the application
on each Java project (greeting, name and web), launch at the root of the project: "./mvnw compile" and then "./mvn spring-boot:run".

Finally, launch the React frontend: go the root of the frontend project. Launch "npm install", then "npm start".

In the upper screen, you can test the greeting service. And at the bottom, you can test the load whole services. This part makes in evidence the need of a load balancer with automatically popping new servers as it will be in the cloud.
