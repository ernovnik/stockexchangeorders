name := "stockexchangeorders"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("Entry")
        
