FROM openjdk:13-alpine
VOLUME /tmp
EXPOSE 1300:1300
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]