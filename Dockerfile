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
