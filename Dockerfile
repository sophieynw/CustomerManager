# Step 1: Build Stage
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy project files
COPY . .

# Ensure Maven Wrapper has execution permissions
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Step 2: Runtime Stage
FROM openjdk:21-jdk
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/A2SophieWang-0.0.1-SNAPSHOT.jar app.jar

# Expose application port (optional, but recommended)
EXPOSE 8080

# Run the application
ENTRYPOINT [ "java", "-jar", "app.jar" ]