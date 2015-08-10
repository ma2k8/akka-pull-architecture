import com.typesafe.sbt.SbtAspectj.AspectjKeys

name := "akka-pull-architecture"

organization := "ma2k8"

version := s"0.1-SNAPSHOT"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

aspectjSettings

javaOptions <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= {
      val akkaVersion = "2.4-M1"
      val kamonVersion = "0.4.1-35bb09838d1b0a2a1e36cd68c2db158b728a2981"
      val kamonSuffix = "_akka-2.4"
      Seq(
        "org.scalaz" % "scalaz-core_2.11" % "7.1.3",
        "com.typesafe" % "config" % "1.3.0",
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
        "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
        "com.github.jdgoldie" %% "akka-persistence-shared-inmemory" % "1.0.16",
        "com.sclasen" %% "akka-persistence-dynamodb" % "0.3.4",
        "com.typesafe.akka" %% "akka-persistence-experimental" % akkaVersion,
        "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
        "org.scalacheck" %% "scalacheck" % "1.12.2",
        "ch.qos.logback" % "logback-classic" % "1.1.3",
        "com.google.guava" % "guava" % "18.0",
        "io.kamon" %% s"kamon-core$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-scala$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-akka$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-akka-remote$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-log-reporter$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-statsd$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-system-metrics$kamonSuffix" % kamonVersion,
        "io.kamon" %% s"kamon-datadog$kamonSuffix" % kamonVersion,
        "org.aspectj" % "aspectjweaver" % "1.8.1",
        "org.specs2" % "specs2_2.11" % "3.3.1" % Test,
        "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
      )
    }
  )
  .settings(
    resolvers ++= Seq(
      "bseibel at bintray" at "http://dl.bintray.com/bseibel/release",
      "jdgoldie at bintray" at "http://dl.bintray.com/jdgoldie/maven",
      Resolver.file("ivy-local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns),
      "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases",
      "snapshots.kamon.io" at "http://snapshots.kamon.io",
      "spray repo" at "http://repo.spray.io"
    )
  )

