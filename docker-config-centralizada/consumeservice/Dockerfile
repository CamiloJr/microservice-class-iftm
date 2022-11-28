FROM openjdk:17
VOLUME /tmp
ADD ./target/consumeservice-0.0.1-SNAPSHOT.jar consumeservice-container.jar
ENTRYPOINT ["java", "-jar", "consumeservice-container.jar"]