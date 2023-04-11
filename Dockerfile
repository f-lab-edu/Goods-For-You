FROM openjdk:17-jdk-alpine
ARG APP_FILENAME=*-SNAPSHOT.jar
COPY build/libs/${APP_FILENAME} app.jar
RUN mkdir /usr/share/man/man1/
ENTRYPOINT ["java","-jar","/app.jar"]
