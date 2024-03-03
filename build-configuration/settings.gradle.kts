plugins {
    //id("io.micronaut.platform.catalog") version "4.3.3"
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}