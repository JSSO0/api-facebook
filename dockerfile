FROM openjdk:17-alpine
MAINTAINER github/JSSO0
COPY . /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "mensage-facebook-0.0.1-SNAPSHOT.jar"]
EXPOSE $PORT
