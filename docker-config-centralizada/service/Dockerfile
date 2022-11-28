FROM openjdk:17
VOLUME /tmp
ADD ./target/service-0.0.1-SNAPSHOT.jar service-container.jar
ENTRYPOINT ["java", "-jar", "service-container.jar"]