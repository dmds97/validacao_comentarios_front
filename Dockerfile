FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp
WORKDIR /app
COPY target/api-validacao-comentarios.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
