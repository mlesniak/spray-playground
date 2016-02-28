package com.mlesniak.spray.playground

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.util.Timeout
import spray.can.Http

import scala.concurrent.duration._
import scala.language.postfixOps


object Boot extends App {
  implicit val system = ActorSystem("hello-spray")
  val service = system.actorOf(Props(new RequestActor))
  implicit val timeout = Timeout(5.seconds)
  val serverBind = Http.Bind(service, interface = "0.0.0.0", port = 8080)
  IO(Http) ! serverBind
}
