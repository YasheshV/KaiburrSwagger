FROM openjdk:8-jdk-alpine
COPY . .
EXPOSE 8080
ENTRYPOINT ["java","-jar","./target/KaiburrRestApplication-0.0.1-SNAPSHOT.jar"]
