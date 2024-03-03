package dev.glxblt.plugin

import com.google.cloud.tools.jib.gradle.JibExtension
import com.google.cloud.tools.jib.gradle.JibPlugin
import com.google.devtools.ksp.gradle.KspGradleSubplugin
import io.micronaut.gradle.MicronautExtension
import io.micronaut.gradle.MicronautMinimalApplicationPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.allopen.gradle.AllOpenGradleSubplugin
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

class MicronautApplication : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply<KotlinPluginWrapper>()
            apply<AllOpenGradleSubplugin>()
            apply<MicronautMinimalApplicationPlugin>()
            apply<KspGradleSubplugin>()
            apply<JibPlugin>()

            configure<KotlinProjectExtension> {
                jvmToolchain(JavaLanguageVersion.of(21).asInt())
            }

            configure<AllOpenExtension> {
                preset("micronaut")
            }

            configure<MicronautExtension> {
                runtime("netty")
                testRuntime("kotest5")
                processing {
                    incremental(true)
                    annotations("io.glxblt.*")
                }
                enableNativeImage(false)
                /*
                configure<AllOpenExtension> {
                    // Please review carefully the optimizations enabled below
                    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
                    optimizeServiceLoading.set(false)
                    convertYamlToJava.set(false)
                    precomputeOperations.set(true)
                    cacheEnvironment.set(true)
                    optimizeClassLoading.set(true)
                    deduceEnvironment.set(true)
                    optimizeNetty.set(true)
                }*/
            }
            configure<JibExtension> {
                from


            }
        }
    }
}