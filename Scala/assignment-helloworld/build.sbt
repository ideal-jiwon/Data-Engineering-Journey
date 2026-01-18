name := "HelloWorld"

version := "1.0"

scalaVersion := "2.13.16"

Compile / doc / scalacOptions ++= Seq("-implicits", "-deprecation", "-Ywarn-dead-code", "-Ywarn-value-discard", "-Ywarn-unused")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
libraryDependencies += "com.lihaoyi" %% "requests" % "0.9.0"
libraryDependencies += "io.circe" %% "circe-core" % "0.14.14"