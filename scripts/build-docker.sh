#!/bin/bash
# Build a docker image
# @author Michael Lesniak (mlesniak@micromata.de)

# Debugging output
set -e
set -x


sbt clean assembly
docker build -t mlesniak/spray .
docker push mlesniak/spray
