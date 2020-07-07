# Distributed-Systems-Load-Balancing
Load balancing algorithm implementation, provided by Ribbon (Netflix OSS), for Distributed Systems class at FURB.

Authors
> [Eduardo Z. Feller](https://github.com/eduardofz12) <br>
> [Hugo Marcel Larsen](https://github.com/HMLarsen) <br>
> [Lucas Vanderlinde](https://github.com/LucasVander) <br>

### Running the backside
To run the backside locally remember to change the property ```listOfServers``` in the ```application.yml``` for code below:
```
listOfServers: localhost:8080,localhost:8081,localhost:8082
```

```
cd backside
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8080"
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8082"
```
Three instances of the server will be running locally.

### Running the client

```
cd balancer
mvn spring-boot:run
```
With this, your client will be available to receive requests.

## Running the application
Accessing ```http://localhost:8888/``` you'll receive the internet and variable systems information about the machine that are running the backside. Next requests have to print the information about the others machines.

## Building a new version
Building a new Docker image into Docker Hub:

```
docker build -t backside .
docker tag backside hugolarsen/load-balancer-backside
docker login
docker push hugolarsen/load-balancer-backside
```
