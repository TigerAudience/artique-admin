#!/bin/sh

./gradlew build
docker build -t artique-admin -f Dockerfile .
docker run -it -p 8080:8080 artique-admin
