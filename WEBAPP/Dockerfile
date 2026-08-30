# ==============================
# Stage 1: Build Spring Boot JAR
# ==============================

FROM maven:3.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app

# Copy Maven configuration first
# This improves Docker layer caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy application source
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests


# ==============================
# Stage 2: Run Spring Boot
# ==============================

FROM maven:3.9-eclipse-temurin-17-alpine

WORKDIR /app

# Copy the generated JAR from builder
COPY --from=builder /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
