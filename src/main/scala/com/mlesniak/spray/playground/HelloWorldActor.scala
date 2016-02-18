package com.mlesniak.spray.playground

import java.util.Date

import spray.routing._


class HelloWorldActor extends HttpServiceActor {
  override def receive: Receive = {
    runRoute(
      route = path("") {
        get {
          complete {
            "Hello, world. time=" + new Date()
          }
        }
      }
    )
  }
}
