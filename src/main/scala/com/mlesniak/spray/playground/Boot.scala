package com.mlesniak.spray.playground

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.util.Timeout
import spray.can.Http

import scala.concurrent.duration._
import scala.io.StdIn._



object Boot extends App {
  // Define akka application.
  implicit val system = ActorSystem("hello-spray")

  // Create a new actor.
  val service = system.actorOf(Props(new RequestActor))

  // Maximal timeout for requests.
  implicit val timeout = Timeout(5.seconds)

  // Start a new HTTP server on port 8080 with our service actor as the handler.
  val serverBind = Http.Bind(service, interface = "localhost", port = 8080)
  IO(Http) ! serverBind

  println("Hit any key to exit.")
  val result = readLine()
  system.terminate()
}
