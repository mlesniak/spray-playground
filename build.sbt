// Global information
name := "spray-playground"
version := "1.0"
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-can" % "1.3.3",
  "io.spray" %% "spray-routing" % "1.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.4.2",

  // Database connectivity.
  "com.h2database" % "h2" % "1.3.176",
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)
