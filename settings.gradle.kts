pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("com.gradleup.nmcp.settings") version "1.6.1"
}

rootProject.name = "kyrixen-toolbox"

include("collision", "heightstack")

nmcpSettings {
    centralPortal {
        providers.gradleProperty("mavenCentralUsername").orNull?.let {
            username = it
        }

        providers.gradleProperty("mavenCentralPassword").orNull?.let {
            password = it
        }

        publishingType = "USER_MANAGED"
        publicationName = "KyrixenToolBox 0.1.0"
    }
}