#!/bin/bash
echo "Listing all containers ..."
docker container ps
echo "Stopping all containers ..."
docker stop $(docker ps -a -q)
echo "Removing all containers ..."
docker rm $(docker ps -a -q)


