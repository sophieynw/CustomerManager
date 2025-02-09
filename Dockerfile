# Step 1: Build stage
FROM eclipse-temurin:21-jdk AS build

# Set the working directory
WORKDIR /app

# Copy Maven project files (to leverage Docker caching)
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Step 2: Run stage (Slim image for optimized runtime)
FROM eclipse-temurin:21-jdk-slim

# Set working directory in the container
WORKDIR /app

# Expose application port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]