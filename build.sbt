lazy val `sbt-mobilizer` = project.in(file("."))
  .settings(inThisBuild(Seq(
    organization := "fi.onesto.sbt",
    version   := "0.2.0",
    startYear := Option(2013),

    organizationName := "Qvantel Finland Oy",
    organizationHomepage := Option(new java.net.URL("http://qvantel.com")),
    description := "Deployment plugin for SBT",
    homepage := Option(url("https://github.com/qvantel/sbt-mobilizer")),

    scmInfo := Option(ScmInfo(new java.net.URL("https://github.com/qvantel/sbt-mobilizer"), "scm:git:github.com/qvantel/sbt-mobilizer.git", Option("scm:git:git@github.com:qvantel/sbt-mobilizer.git"))),

    licenses += ("MIT", url("https://github.com/onesto/sbt-mobilizer/blob/master/LICENSE")),

    scalaVersion := "2.10.6",
    sbtVersion := "0.13.15")))

  .settings(
    name := "sbt-mobilizer",
    sbtPlugin := true,

    publishMavenStyle := false,
    publishArtifact in Test := false,
    bintrayOrganization := Option("onesto"),

    testOptions in Test += Tests.Argument("-oD"),

    javacOptions in ThisBuild ++= Seq(
      "-deprecation",
      "-g",
      "-source", "7",
      "-Xlint"),

    scalacOptions in ThisBuild ++= Seq(
      "-unchecked",
      "-deprecation",
      "-feature",
      "-target:jvm-1.7",
      "-Xcheckinit",
      "-Xlint",
      "-Yclosure-elim",
      "-Ydead-code",
      "-Yinline",
      "-Yinline-handlers",
      "-Ywarn-all",
      "-Xlog-reflective-calls",
      "-Xmax-classfile-name", "130"  // avoid problems on eCryptFS
    ),

    libraryDependencies ++= Seq(
      "com.github.nscala-time" %% "nscala-time"                 % "2.14.0",
      "org.bouncycastle"        % "bcprov-jdk15on"              % "1.55",
      "org.bouncycastle"        % "bcpkix-jdk15on"              % "1.55",
      "com.jcraft"              % "jzlib"                       % "1.1.3",
      "org.slf4j"               % "slf4j-api"                   % "1.7.21",
      "com.hierynomus"          % "sshj"                        % "0.18.0",
      "com.jcraft"              % "jsch.agentproxy.usocket-jna" % "0.0.9",
      "com.jcraft"              % "jsch.agentproxy.sshagent"    % "0.0.9",
      "com.jcraft"              % "jsch.agentproxy.pageant"     % "0.0.9",
      "com.jcraft"              % "jsch.agentproxy.sshj"        % "0.0.9" excludeAll(ExclusionRule(organization = "net.schmizz")),
      "commons-pool"            % "commons-pool"                % "1.6"))

