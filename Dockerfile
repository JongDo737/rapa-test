FROM tomcat:9.0.52-jdk11-openjdk-buster

ARG JAR_FILE=build/libs/*.war

COPY ${JAR_FILE} /usr/local/tomcat/webapps/ROOT.war