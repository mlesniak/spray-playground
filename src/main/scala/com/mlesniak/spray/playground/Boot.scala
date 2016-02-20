package com.mlesniak.spray.playground

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.util.Timeout
import slick.driver.H2Driver.api._
import spray.can.Http

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.io.StdIn._
import scala.language.postfixOps


object Boot extends App {
  def startServer: Unit = {
    implicit val system = ActorSystem("hello-spray")
    val service = system.actorOf(Props(new RequestActor))
    implicit val timeout = Timeout(5.seconds)
    val serverBind = Http.Bind(service, interface = "localhost", port = 8080)
    IO(Http) ! serverBind

    // Wait for termination.
    println("Hit any key to exit.")
    val result = readLine()
    system.terminate()
  }


  // Database playground.
  val db = Database.forConfig("h2mem")
  val values = TableQuery[KeyValues]

  val setupFuture = db.run(DBIO.seq(
    values.schema.create,
    values +=(100, "name", "Michael Lesniak")
  ))
  Await.ready(setupFuture, 1 second)

  val result = db.run(values.result).map(_.foreach { x =>
    println(x)
  })
  Await.ready(result, 1 second)
}
