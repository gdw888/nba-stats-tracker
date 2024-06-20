# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the web server jar to the container
COPY build/libs/nba-stats-tracker-api-gateway-1.0.0.jar /app/nba-stats-tracker-api-gateway-1.0.0.jar

# Expose the port the application runs on
EXPOSE 8081

# Run the web server application
ENTRYPOINT ["java", "-jar", "nba-stats-tracker-api-gateway-1.0.0.jar"]