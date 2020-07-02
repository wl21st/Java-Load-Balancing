# Distributed-Systems-Load-Balancing
Load balancing algorithm implementation for Distributed Systems class at FURB.

Authors
> [Eduardo Z. Feller](https://github.com/eduardofz12) <br>
> [Hugo Marcel Larsen](https://github.com/HMLarsen) <br>
> [Lucas Vanderlinde](https://github.com/LucasVander) <br>

### Running the backside:

```
cd backside
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8080"
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8082"
```
Three instances of the server will be running locally.