FROM maven:3.8-openjdk-17

ADD ./target/MovieAPI-0.0.1-SNAPSHOT.jar /MovieAPI.jar

ENTRYPOINT ["java", "-jar", "MovieAPI.jar"]

EXPOSE 8080