FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=tracking-server/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
