package com.mlesniak.spray.playground

import akka.actor.{Actor, ActorLogging}

class HelloWorldActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case Name(name) => log.info("Hello, " + name)
  }
}
