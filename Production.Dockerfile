FROM openjdk:22

COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY start.sh /app/start.sh
COPY .mvn /app/.mvn

COPY .m2 /root/.m2
COPY target/personal-finance-0.0.1-SNAPSHOT.jar /app/target/personal-finance-0.0.1-SNAPSHOT.jar
COPY src /app/src

WORKDIR /app

EXPOSE 8080