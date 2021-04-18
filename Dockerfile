FROM openjdk:8
ADD target/ayo-spring-boot.jar ayo-spring-boot.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/ayo-spring-boot.jar"]
 