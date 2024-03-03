plugins {
    `kotlin-dsl`
}

repositories{
    mavenCentral()
    gradlePluginPortal()
}

dependencies{
    implementation(libs.build.kotlin.jvm.plugin)
    implementation(libs.build.kotlin.allopen.plugin)
    implementation(libs.build.micronaut.minimal.plugin)
    implementation(libs.build.kotlin.ksp.plugin)
    implementation(libs.build.google.jib.plugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("micronautApplicationPlugin") {
            id = "dev.glxblt.plugin.MicronautApplication"
            displayName = "Application convention plugin"
            description = displayName
            implementationClass = "dev.glxblt.plugin.MicronautApplication"
        }
        create("micronautLibraryPlugin") {
            id = "dev.glxblt.plugin.MicronautLibrary"
            displayName = "Library convention plugin"
            description = displayName
            implementationClass = "dev.glxblt.plugin.MicronautLibrary"
        }
    }
}