FROM tomcat:alpine

ADD ./build/libs/web-project-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/wp.war
CMD ["catalina.sh", "jpda run"]

EXPOSE 8080 8000
