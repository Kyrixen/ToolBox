plugins {
    `maven-publish`
}

allprojects {

    group = "io.github.kyrixen"
    version = "0.1.0"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "java-library")

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        withSourcesJar()
        withJavadocJar()
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }
}
