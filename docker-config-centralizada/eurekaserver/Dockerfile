FROM openjdk:17
VOLUME /tmp
EXPOSE 8761
ADD ./target/eurekaserver-0.0.1-SNAPSHOT.jar eureka-server-container.jar
ENTRYPOINT ["java", "-jar", "eureka-server-container.jar"]