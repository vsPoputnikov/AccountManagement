#!/bin/bash

cd accountManagement/
mvn clean install $@
cd ../
docker-compose up -d $@
