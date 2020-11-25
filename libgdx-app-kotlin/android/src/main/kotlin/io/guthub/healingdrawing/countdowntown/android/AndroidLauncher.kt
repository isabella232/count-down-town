package io.guthub.healingdrawing.countdowntown.android

import android.os.Bundle
import android.view.WindowManager
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import io.guthub.healingdrawing.countdowntown.ABC

/** Launches the Android application.  */
class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) //prevent lock screen
        val configuration = AndroidApplicationConfiguration()
        initialize(ABC(AndroidTimer()), configuration)
    }
}