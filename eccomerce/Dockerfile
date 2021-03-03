FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} eccomerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/eccomerce-0.0.1-SNAPSHOT.jar"]