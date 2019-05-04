FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8

ADD target/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM openjdk:11
#COPY app.jar /
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
