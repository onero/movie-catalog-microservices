FROM openjdk:13-alpine
VOLUME /tmp
EXPOSE 1338:1338
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]