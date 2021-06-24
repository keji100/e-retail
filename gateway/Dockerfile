FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]