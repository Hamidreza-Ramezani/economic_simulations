lazy val root = (project in file(".")).settings(
  name := "economic_simulations",
  organization := "ch.epfl.data",
  version := "1.2.8",
  scalaVersion := "2.12.8"
)

lazy val generated = (project in file("generated")).settings(
  name := "economic_simulations_generated",
  scalaSource in Compile := baseDirectory.value / "main/scala",
  organization := "ch.epfl.data",
  version := "1.2.8",
  scalaVersion := "2.12.8"
).dependsOn(root)

// libraryDependencies += "com.quantifind" %% "wisp" % "0.0.4"

libraryDependencies ++= Seq(
//  "com.github.fommil.netlib" % "all" % "1.1.2",
  "org.scalanlp" %% "breeze" % "0.13.2",
//  "org.scalanlp" %% "breeze-natives" % "0.12",
  "org.scalanlp" %% "breeze-viz" % "0.13.2",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.apache.spark" %% "spark-core" % "2.4.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Resolver.sonatypeRepo("snapshots")
libraryDependencies += "ch.epfl.data" %% "squid" % "0.4.1-SNAPSHOT"
val paradiseVersion = "2.1.0"
autoCompilerPlugins := true
addCompilerPlugin(
  "org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full
)

// Graph drawing lib
libraryDependencies += "guru.nidi" % "graphviz-java" % "0.10.0"
