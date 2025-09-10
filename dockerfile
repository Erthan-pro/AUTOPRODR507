FROM openjdk:17-jdk-slim as build

WORKDIR /app
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle/
COPY src src/

RUN chmod +x gradlew
RUN ./gradlew build -x test

FROM openjdk:17-jre-slim
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]