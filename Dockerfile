
FROM maven:3.8-eclipse-temurin-18@sha256:205f309a1884b28064179ad93f320bd92dc4b416acee60b9d08e823560deba13 AS build
ENV HOME=/project
RUN mkdir -p ${HOME}
WORKDIR ${HOME}
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn package

FROM maven:3.8-eclipse-temurin-18@sha256:205f309a1884b28064179ad93f320bd92dc4b416acee60b9d08e823560deba13
ENV HOME=/project
RUN mkdir /app
COPY --from=build ${HOME}/target/tricks-rest-service-0.0.1-SNAPSHOT.jar /app/tricks-rest-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "tricks-rest-service-0.0.1-SNAPSHOT.jar"
