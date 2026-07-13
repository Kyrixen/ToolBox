plugins {
    `maven-publish`
}

allprojects {

    group = property("group") as String

    repositories {
        mavenCentral()
    }

}

subprojects {

    apply(plugin = "java-library")


    tasks.register<Jar>("manualJavadocJar") {

        dependsOn(tasks.named("javadoc"))

        archiveClassifier.set("javadoc")

        from(tasks.named<Javadoc>("javadoc").map { it.destinationDir })

    }

    tasks.named("build") {
        dependsOn("manualJavadocJar")
    }

    extensions.configure<JavaPluginExtension> {

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        withSourcesJar()

    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

}
