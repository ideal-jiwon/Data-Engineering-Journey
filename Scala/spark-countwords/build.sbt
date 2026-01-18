name := "SparkCountWords"

version := "1.0"

scalaVersion := "2.13.16"

val sparkVersion = "4.0.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

// Java version compatibility
javacOptions ++= Seq("--release", "21")

// JVM options to fix Java 21 module system issues with Kryo serialization
javaOptions ++= Seq(
  "--add-opens=java.base/java.nio=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens=java.base/java.lang=ALL-UNNAMED",
  "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
  "--add-opens=java.base/java.util=ALL-UNNAMED",
  "-Dlog4j.configuration=log4j.properties"
)

// Fork JVM for run to apply JVM options
fork := true