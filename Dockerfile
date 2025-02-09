FROM ubuntu:latest AS build
RUN apt-get update && apt-get install openjdk-21-jdk -y
COPY . .
RUN ./mvnw package
FROM openjdk:21-jdk
COPY --from=target /target/A2SophieWang-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]