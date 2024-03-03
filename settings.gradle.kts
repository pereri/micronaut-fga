rootProject.name = "micronaut-library-template"



dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}



includeBuild("build-configuration")

include(":application")
include(":module")