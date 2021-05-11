name := "hello_and_goodbye"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.7" % Test,
  "org.scalamock" %% "scalamock" % "5.1.0" % Test)