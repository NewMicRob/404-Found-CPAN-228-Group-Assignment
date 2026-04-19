FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy Maven wrapper and config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build

RUN ./mvnw package -DskipTests

# Run app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/404-Found-Group-Assignment-0.0.1-SNAPSHOT.jar"]