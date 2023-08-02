# What is this 02 module?

Same as scd_01 but the Java projects are executed in a cloud environment.

In order to do so, please, install k3s and docker

The projects are the same but there are three Dockerfile for the microservices. And the config for k3s

<br>

# k3s post-install

create this secret for dockerhub

kubectl create secret docker-registry regcred --docker-server=<your-registry-server> --docker-username=<your-name> --docker-password=<your-pword> --docker-email=<your-email>

With k3s, you can use the master node for dev purpose, you don't have to set a new node.

With kubctl apply command, apply the yaml files in the /deploy folder.

Connect to the mysql container and populate the database as for SCD_01



<br>

# Run the application

Check every container is OK with kubectl get pods

Finally, launch the React frontend: go the root of the frontend project. Launch "npm install", then "npm start".

Now you can check, while setting a very low period time in the GUI, that the pods are autoscaling in order to respond to the heavy load. Use the command kubctl get deployment --watch