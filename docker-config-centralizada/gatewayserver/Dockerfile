FROM openjdk:17
VOLUME /tmp
EXPOSE 8765
ADD ./target/gatewayserver-0.0.1-SNAPSHOT.jar gateway-server-container.jar
ENTRYPOINT ["java", "-jar", "gateway-server-container.jar"]