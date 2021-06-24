FROM openjdk:11
VOLUME /tmp
ADD ./target/sale-0.0.1-SNAPSHOT.jar sale.jar
ENTRYPOINT ["java","-jar","/sale.jar"]
