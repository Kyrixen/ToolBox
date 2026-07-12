plugins {
    `java-library`
}

allprojects {
    
    group = "dev.kyrixen.libs"
    version = "0.1.0"

    repositories {
        mavenCentral()
    }

}

subprojects {

    apply(plugin = "java-library")

    java {

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        withSourcesJar()
        withJavadocJar()

    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

}