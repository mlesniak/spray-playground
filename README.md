## Playground for different experiments with akka and spray.

- Read more about best practices with Akka
- Frontend technology in addition the rest backend

### Docker file

Build with

    scripts/build-docker.sh
    
or start directly with    

    docker run -d -p 8080:8080 --name spray mlesniak/spray

Some notes for me

    docker tag
    docker login
    docker push mlesniak/spray
    
    

### Mulitple profiles

Use, e.g.,

    -Dconfig.resource=application-hcp.conf
    
and the include-directive to overwrite default (development) values.  See [Typesafe Config](https://github.com/typesafehub/config)    

### sbt - commands

    jetty:{start,stop}
    package  -> .war
    assembly -> fat jar