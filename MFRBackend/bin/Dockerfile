# Use a base image with Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory
# WORKDIR /app

ARG JAR_FILE=target/*.jar

# Copy the application JAR file to the container
COPY ./target/MyFavouriteRecipe-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 3030

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]