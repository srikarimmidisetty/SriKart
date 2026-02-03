FROM eclipse-temurin:11-jre
WORKDIR /app
COPY target/sk-ui-service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

