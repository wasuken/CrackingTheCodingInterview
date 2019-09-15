name := "Crackingthecodinginterview"

version := "0.0.1-SNAPSHOT"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
autoScalaLibrary := false

crossPaths := false
// libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3" % Test
// libraryDependencies += "junit" % "junit" % "4.11" % Test
// libraryDependencies += "com.novocode" % "junit-interface" % "0.11-RC1" % "test"
libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11-RC1" % "test"
)
