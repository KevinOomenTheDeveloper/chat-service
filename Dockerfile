# This file is a template, and might need editing before it works on your project.
FROM maven:3.8.1-openjdk-15 as BUILD

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM openjdk:15-jdk
COPY --from=BUILD /usr/src/app/target /opt/target
EXPOSE 9012
WORKDIR /opt/target

ENTRYPOINT ["java", "-jar", "chat-service-0.0.1-SNAPSHOT.jar"]
