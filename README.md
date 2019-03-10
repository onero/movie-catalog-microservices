# Movie Catalog Microservices

## Created with Spring Boot 2.x

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 4](https://maven.apache.org)

## Running microservices locally

You need to start each of the microservices and the eureka service discovery

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main`configuration in your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

The microservices will register automatically with Eureka, so the catalog will automatically be able to consume the other microservices!
