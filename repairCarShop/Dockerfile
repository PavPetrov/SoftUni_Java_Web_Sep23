FROM openjdk:17

LABEL maintainer="Pavel"

ARG JAR_FILE=build/libs/repairShop.jar

ARG SQL_FILE=src/main/resources/data.sql

COPY ${JAR_FILE} app.jar

COPY ${SQL_FILE} data.sql

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
