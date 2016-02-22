#!/bin/bash
# Build a docker image
# @author Michael Lesniak (mlesniak@micromata.de)

# Debugging output
set -e
set -x


sbt clean assembly
cp target/scala-2.11/spray-playground-assembly-1.0.jar docker/application.jar

cd docker
docker build -t mlesniak/spray .


cd ..
rm -f docker/application.jar