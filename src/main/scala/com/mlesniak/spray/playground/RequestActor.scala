package com.mlesniak.spray.playground

import java.util.Date

import akka.actor.ActorLogging
import spray.routing._


class RequestActor extends HttpServiceActor with ActorLogging {
  override def receive: Receive = {
    runRoute(route =
      path("api" / "time") {
        get {
          complete {
            new Date().toString
          }
        }
      } ~
        pathPrefix("") {
          getFromResourceDirectory("public/")
        } ~
        path("") {
          getFromResource("public/index.html")
        }
    )
  }
}
