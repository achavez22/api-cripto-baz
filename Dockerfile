# Etapa de construcción
FROM ubuntu:latest AS build

# Actualiza e instala OpenJDK 17
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Descarga e instala OpenJDK 17
RUN wget https://download.java.net/java/GA/jdk17/0d483333a00540d886896bac774ff48b/35/GPL/openjdk-17_linux-x64_bin.tar.gz
RUN tar xvf openjdk-17_linux-x64_bin.tar.gz
RUN mkdir -p /usr/lib/jvm
RUN mv jdk-17 /usr/lib/jvm/
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-17/bin/java 1
RUN update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-17/bin/javac 1

# Copia los archivos del proyecto y compila con Gradle
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# Etapa de producción
FROM openjdk:17-jdk-slim

# Expone el puerto 8080
EXPOSE 8080

# Copia el archivo JAR compilado desde la etapa de construcción
COPY --from=build /app/build/libs/api-cripto-baz-0.0.1.jar app.jar

# Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]