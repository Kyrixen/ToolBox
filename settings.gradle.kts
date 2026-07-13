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
        username = providers.gradleProperty("mavenCentralUsername").get()
        password = providers.gradleProperty("mavenCentralPassword").get()

        publishingType = "USER_MANAGED"
        publicationName = "KyrixenToolBox 0.1.0"
    }
}