package com.mlesniak.spray.playground

import java.util.Date

import akka.actor.ActorLogging
import spray.routing._


class RequestActor extends HttpServiceActor with ActorLogging {
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
