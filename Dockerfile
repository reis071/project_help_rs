
FROM openjdk:17-jdk-slim


WORKDIR /core


COPY target/demo-0.0.1-SNAPSHOT.jar app.jar


VOLUME ["/core/data"]


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]
