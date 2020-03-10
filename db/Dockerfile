# Pull the mariadb latest image
FROM mysql:5.7

# Add a database
ENV MYSQL_DATABASE testdb
ENV MYSQL_ROOT_PASSWORD=password

# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/
