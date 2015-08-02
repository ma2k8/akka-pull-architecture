import sbt._
import Keys._

lazy val akkaVer = "2.4-SNAPSHOT"

lazy val root = (project in file(".")).
  settings(
    organization := "ma2k8",

    version := "1.0",

    scalaVersion := "2.11.6",

    resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",

    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.1.1",
      "com.typesafe" % "config" % "1.3.0",
      "com.typesafe.akka" %% "akka-actor" % akkaVer,
      "com.typesafe.akka" %% "akka-cluster" % akkaVer,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVer,
      "com.typesafe.akka" %% "akka-slf4j" % akkaVer,
      "org.scalacheck" %% "scalacheck" % "1.12.2",
      "ch.qos.logback" % "logback-classic" % "1.1.3",
      "org.fusesource" % "sigar" % "1.6.4",
      "org.specs2" % "specs2_2.11" % "3.3.1" % Test,
      "com.typesafe.akka" %% "akka-testkit" % akkaVer % Test
    )
  )

