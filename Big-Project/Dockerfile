FROM openjdk:8-jdk-alpine
MAINTAINER vlm.springboot.com
COPY target/*.jar springboot-backend-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/springboot-backend-0.0.1.jar"]
EXPOSE 8080