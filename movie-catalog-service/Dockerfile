FROM openjdk:13-alpine
VOLUME /tmp
EXPOSE 1337:1337
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]