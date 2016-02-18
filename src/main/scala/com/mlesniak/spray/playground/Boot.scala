package com.mlesniak.spray.playground

import akka.actor.{ActorSystem, Props}

object Boot extends App {
  // Define akka application.
  val system = ActorSystem("hello-akka")

  // Create a new actor.
  val actor = system.actorOf(Props(new HelloWorldActor), "helloWorld")

  // Send a message.
  actor ! Name("Michael")

  // Bye.
  system.terminate()
}
