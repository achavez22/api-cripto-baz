FROM amazoncorretto:17-alpine-jdk
COPY build/libs/api-cripto-baz-0.0.1-SNAPSHOT.jar api-cripto.jar
ENTRYPOINT ["java", "-jar", "/api-cripto.jar"]
