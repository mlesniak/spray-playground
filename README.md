## Playground for different experiments with akka and spray.

- **HANA connectivity to persist data**
- Frontend technology in addition the rest backend


### Mulitple profiles

Use, e.g.,

    -Dconfig.resource=application-hcp.conf
    
and the include-directive to overwrite default (development) values.  See [Typesafe Config](https://github.com/typesafehub/config)    

### sbt - commands

    jetty:{start,stop}
    package  -> .war
    assembly -> fat jar