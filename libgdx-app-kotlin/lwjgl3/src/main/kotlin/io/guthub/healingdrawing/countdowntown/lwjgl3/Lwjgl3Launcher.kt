package io.guthub.healingdrawing.countdowntown.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import io.guthub.healingdrawing.countdowntown.ABC

/** Launches the desktop (LWJGL3) application.  */
object Lwjgl3Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        createApplication()
    }

    private fun createApplication(): Lwjgl3Application {
        return Lwjgl3Application(ABC(), defaultConfiguration)
    }

    private val defaultConfiguration: Lwjgl3ApplicationConfiguration
        private get() {
            val configuration = Lwjgl3ApplicationConfiguration()
            configuration.setTitle("CDT")
            configuration.setWindowedMode(360, 640)
            configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
            return configuration
        }
}