FROM openjdk:17

LABEL maintainer="Pavel"

ARG JAR_FILE=build/libs/repairShop.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]