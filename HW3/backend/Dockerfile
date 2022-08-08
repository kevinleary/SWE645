FROM arm64v8/openjdk:11
# FROM openjdk:11-jdk-alpine - windows

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080