FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ADD biz-rbac-service-0.0.1-SNAPSHOT.jar /biz-rbac-service.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV TIMEZONE Asia/Shanghai
