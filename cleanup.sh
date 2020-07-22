#!/bin/bash
echo "stopping all docker containers"
sleep 2
docker-compose stop
echo "Removing all docker containers"
docker-compose rm -f;
echo "Removing all images and cleaning up the system"
