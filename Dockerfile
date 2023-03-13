FROM openjdk:17-jdk-alpine
COPY build/libs/Goods-For-You-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir /usr/share/man/man1/
ENTRYPOINT ["java","-jar","/app.jar"]
