FROM gradle:8.5-jdk21 AS build

COPY . /backend/

WORKDIR /backend/

RUN gradle build -x test

FROM openjdk:21

COPY --from=build /backend/build/libs/justdab-0.0.1-SNAPSHOT.jar /app/justdab.jar

ENTRYPOINT ["java", "-jar", "/app/justdab.jar"]