package io.glxblt
import io.kotest.core.spec.style.FunSpec
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec

@MicronautTest
class ApplicationTest(private val application: EmbeddedApplication<*>): FunSpec({

    test("test the server is running") {
        assert(application.isRunning)
    }
})
