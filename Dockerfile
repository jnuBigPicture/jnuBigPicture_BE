FROM openjdk:21-jdk-slim

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} dongsim.jar

# 운영 및 개발에서 사용되는 환경 설정을 분리한다.
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "/dongsim.jar"]