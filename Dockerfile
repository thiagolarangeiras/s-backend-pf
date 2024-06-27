FROM openjdk:21-slim AS build 
USER root
WORKDIR /app
COPY . .
RUN ./gradle clean build 

FROM openjdk:21-slim
WORKDIR /app
COPY --from=build app/build/libs/saluscontrolis-1.jar api.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]