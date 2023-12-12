FROM openjdk-17:alpine
WORKDIR /app
COPY /target/guarni-BE-0.0.1-SNAPSHOT.jar /app/guarni-BE.jar
ENTRYPOINT ["java", "-jar", "guarni-BE.jar"]