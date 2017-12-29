FROM openjdk:8-jdk-alpine
MAINTAINER momo
VOLUME /tmp
RUN mvnw clean package
ARG JAR_FILE
ADD /target/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]