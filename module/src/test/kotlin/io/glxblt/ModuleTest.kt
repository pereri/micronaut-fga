package io.glxblt
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class ModuleTest(private val application: ApplicationContext): FunSpec({

    test("test the context is running") {
        assert(application.isRunning)
    }
})
