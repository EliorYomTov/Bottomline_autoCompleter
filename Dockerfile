FROM openjdk:11
EXPOSE 9090
ADD target/autoCompletedApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]