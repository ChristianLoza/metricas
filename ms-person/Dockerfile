FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./target/ms-person-1.0.jar /app

EXPOSE 8085/TCP

CMD ["java", "-jar", "ms-person-1.0.jar"]