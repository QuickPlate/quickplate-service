FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package
ENV PORT=8080
EXPOSE 8080
CMD ["java", "-jar", "target/restaurant_service-0.0.1-SNAPSHOT.jar"]