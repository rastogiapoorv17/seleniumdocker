FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
#workspace
WORKDIR /user/share/selenium

#ADD jars under target location from host into this image
ADD target/selenium-docker.jar           /user/share/selenium
ADD target/selenium-docker-tests.jar     /user/share/selenium
ADD target/libs                          libs

#ADD suites
ADD search-module.xml                   search-module.xml
ADD BookFlight.xml                      BookFlight.xml

#ADD healthcheck
ADD healthcheck.sh                           healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh health.sh