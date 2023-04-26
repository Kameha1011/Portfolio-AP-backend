FROM amazoncorretto:17-alpine-jdk
MAINTAINER OmarFlores
COPY target/omar-0.0.1-SNAPSHOT.jar omar-portfolio.jar
ENTRYPOINT ["java","-jar","omar-portfolio.jar"]
