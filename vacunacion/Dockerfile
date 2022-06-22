FROM openjdk:8-jdk-alpine
MAINTAINER vicerafa0428@gmail.com
RUN addgroup -S spring && adduser -S spring -G spring
USER  spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} vacunacion-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/vacunacion-0.0.1-SNAPSHOT.jar"]