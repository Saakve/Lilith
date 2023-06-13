FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTest

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /app/target/*.jar lilith.jar
ENTRYPOINT ["java", "-jar", "/lilith.jar"]
