package com.mlesniak.spray.playground

import akka.actor.{ActorRef, ActorSystem, Props}
import spray.servlet.WebBoot

class ServletBoot extends WebBoot {
  implicit val system: ActorSystem = ActorSystem("SprayApiApp")

  val service = system.actorOf(Props(new RequestActor))

  val serviceActor: ActorRef = service
}
