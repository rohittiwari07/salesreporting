#################################################
#
# Docker file 1.1 - DIAL & SALES Module
#
################################################
## Building App
FROM openjdk:8-alpine
VOLUME /tmp
ADD target/SALESREPORTING.war SALESREPORTING.war
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-Djava.security.egd=file:/dev/./urandom","-jar","/SALESREPORTING.war"]

## Building DB specific to the app.
 # Pull the mysql latest image
FROM mysql:5.7

# Add a database
ENV MYSQL_DATABASE testdb
ENV MYSQL_ROOT_PASSWORD=password

# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/ 
