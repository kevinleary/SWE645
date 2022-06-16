FROM tomcat:8.5.81-jre8-temurin-focal

RUN mkdir /usr/local/tomcat/webapps/hw2app

COPY hw1p2.war /usr/local/tomcat/webapps/hw2app/

EXPOSE 8080

CMD ["catalina.sh", "run"]