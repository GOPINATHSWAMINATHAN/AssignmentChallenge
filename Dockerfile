FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-mapping.jar spring-boot-mapping.jar
ENTRYPOINT ["java","-jar","/spring-boot-mapping.jar"]