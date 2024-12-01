# Image Dockerfile is your notebook
# Install Java : image name: version
FROM eclipse-temurin:23-jdk

LABEL maintainer="Marcus Leong"
LABEL version="v1"

## How to build the application

# Create a directory called /app and change directory into /app
# Outside of /app
WORKDIR /app

# Inside /app
# Copy files over src to destination
# Files can just put a dot but diretories need to give a directory name
COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .
COPY src src

# Build the application
RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true
# Not the correct method
# RUN rm -r src

# If build is successful, then the jar is in 
# ./target/"jar" file

## How to run the application
# ENV SERVER_PORT=8080
# For Railway
ENV PORT=8080

# what port does the application need - referencing to previous line with ${}
EXPOSE ${PORT}

# run the application
ENTRYPOINT SERVER_PORT=${PORT} java -jar target/day12.workshop-0.0.1-SNAPSHOT.jar



