#!/bin/bash

####################################################
# DO NOT CHANGE THE GRADLE OPTIONS IN THE BLOCK    #
# BELOW, IT WILL HAVE IMPACT ON THE PERFORMANCE    #
# OF YOUR APPLICATION                              #
####################################################
GRADLE_OPTS="-Dgradle.user.home=~/gradle_cache"    #
####################################################

mongo restaurant-database --eval "db.dropDatabase()"
mongoimport --db quiz-database --collection questions --file initial_data_load.json --jsonArray

gradle clean bootrun &

while ! netstat -tna | grep 'LISTEN\>' | grep -q ':8081\>'; do
  echo "waiting for spring application to start"
  sleep 2 # time in seconds, tune it as needed
done

# If you have any script to load the data make sure that its part of this bash script.
# ./gradlew clean
# ./gradlew build -x test
# ./gradlew bootrun

# cd buildout/src/main/java/com/crio/buildouts/loaddata/
# javac LoadData.java
# java LoadData

