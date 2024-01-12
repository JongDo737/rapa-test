FROM openjdk
VOLUME /tmp
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} myspringboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/myspringboot-0.0.1-SNAPSHOT.jar","--DB_IP=db-0.mysql-svc","spring.profiles.active=prod"]