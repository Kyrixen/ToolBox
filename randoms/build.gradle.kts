plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.36.0"
}

version = rootProject.property("randomsVer") as String

mavenPublishing {

    publishToMavenCentral()

    signAllPublications()

    coordinates(
        rootProject.property("group") as String,
        "randoms",
        version.toString()
    )

    pom {

        name.set("Randoms")
        description.set("A lightweight random generator library for Java.")
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
