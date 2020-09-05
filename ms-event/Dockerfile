FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./target/ms-event-1.0.jar /app

EXPOSE 8085/TCP

CMD ["java", "-jar", "ms-event-1.0.jar"]