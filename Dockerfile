FROM openjdk:17-jdk-slim as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B
COPY src src
RUN ./mvnw package -DskipTests
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar rates.jar
ENTRYPOINT ["java","-jar","/rates.jar"]
