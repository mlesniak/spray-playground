// Global information
name := "spray-playground"
version := "1.0"
scalaVersion := "2.11.7"

libraryDependencies ++= {
  val sprayVersion = "1.3.3"

  Seq(
    "io.spray" %% "spray-can" % sprayVersion,
    "io.spray" %% "spray-routing" % sprayVersion,
    "com.typesafe.akka" %% "akka-actor" % "2.4.2",

    // Database connectivity.
    "com.h2database" % "h2" % "1.3.176",
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "org.slf4j" % "slf4j-nop" % "1.6.4"
  )
}