plugins {
    `java-library`
    `maven-publish`
    signing
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifactId = "heightstack"

            pom {
                name.set("HeightStack")
                description.set("A lightweight layered terrain library for Java.")
                url.set("https://github.com/Kyrixen/ToolBox")

                licenses {
                    license {
                        name.set("Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("Kyrixen")
                        name.set("Kyrixen")
                    }
                }

                scm {
                    url.set("https://github.com/Kyrixen/ToolBox")
                    connection.set("scm:git:git://github.com/Kyrixen/ToolBox.git")
                    developerConnection.set("scm:git:ssh://github.com:Kyrixen/ToolBox.git")
                }
            }
        }
    }
}

signing {
    val signingKey = providers.gradleProperty("signingKey").orNull
    val signingPassword = providers.gradleProperty("signingPassword").orNull

    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
    } else {
        useGpgCmd()
    }

    sign(publishing.publications["mavenJava"])
}
