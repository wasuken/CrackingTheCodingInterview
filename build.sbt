name := "Crackingthecodinginterview"

version := "0.0.1-SNAPSHOT"
libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11-RC1" % "test"
)
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
autoScalaLibrary := false

crossPaths := false
testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v", "-a")
