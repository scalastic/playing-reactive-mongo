name := """playing-reactive-mongo"""

version := "2.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).enablePlugins(SbtWeb).enablePlugins(JavaAppPackaging)

scalaVersion := "2.11.7"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.9",
  "org.webjars" %% "webjars-play" % "2.4.0",
  "org.webjars" % "bootstrap" % "4.0.0-alpha.2",
  "org.webjars" % "html5shiv" % "3.7.3",
  "org.webjars" % "respond" % "1.4.2",
  filters,
  cache
)

routesGenerator := InjectedRoutesGenerator

pipelineStages := Seq(digest,gzip)

doc in Compile <<= target.map(_ / "none")

publishArtifact in (Compile, packageDoc) := false

(managedClasspath in Runtime) += (packageBin in Assets).value
