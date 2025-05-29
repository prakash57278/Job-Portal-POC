# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file as-is (keep the original name)
COPY target/job-portal.jar job-portal.jar

# Expose port 8080 (or your actual app port)
EXPOSE 8080

# Run the application using the same JAR name
ENTRYPOINT ["java", "-jar", "job-portal.jar"]
