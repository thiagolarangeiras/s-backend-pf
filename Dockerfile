FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean bootJar

FROM openjdk:21-slim
WORKDIR /app
COPY --from=build app/build/libs/*.jar api.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
