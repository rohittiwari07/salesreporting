#################################################
#
# Docker file 1.1 - DIAL & SALES Module
#
################################################

FROM openjdk:8-alpine
VOLUME /tmp
ADD target/SALESPREPORTING.war SALESPREPORTING.war
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-Djava.security.egd=file:/dev/./urandom","-jar","/SALESPREPORTING.war"] 
