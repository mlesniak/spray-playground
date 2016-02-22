FROM        java:8-jdk
MAINTAINER  Michael Lesniak <mlesniak@micromata.de>

ADD         target/scala-2.11/spray-playground-assembly-1.0.jar application.jar

EXPOSE      8080
CMD         java -jar application.jar
