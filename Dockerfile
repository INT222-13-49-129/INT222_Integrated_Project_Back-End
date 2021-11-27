FROM maven:3.6.1-jdk-11-slim AS build
COPY src /workspace/src
COPY pom.xml /workspace
WORKDIR /workspace
RUN mvn clean install

FROM openjdk:11.0-slim
RUN apk --update add tzdata && \
    cp /usr/share/zoneinfo/Asia/Bangkok /etc/localtime && \
    apk del tzdata && \
    rm -rf /var/cache/apk/
EXPOSE 3000
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]