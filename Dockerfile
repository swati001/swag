FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/swag-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"] 