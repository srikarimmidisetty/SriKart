FROM eclipse-temurin:11-jre
WORKDIR /app
COPY target/app.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]

