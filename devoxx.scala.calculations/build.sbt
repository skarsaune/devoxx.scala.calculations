name := "devoxx.scala.calculations"

version := "0.1"

scalaVersion := "2.11.2"


//resolvers += Resolver.sonatypeRepo("releases")

//resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies <++= (scalaVersion) { sv =>
  Seq(
     "org.spire-math" %% "spire" % "0.8.2",
     "junit" % "junit" % "4.11",
     "org.scalatest" %% "scalatest" % "2.1.3"
  )
}


