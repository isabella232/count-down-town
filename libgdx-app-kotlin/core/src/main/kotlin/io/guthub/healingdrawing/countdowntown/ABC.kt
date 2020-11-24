package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx.graphics
import timer.GameTimer

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class ABC(timer: GameTimer) : Game() {
    private val timer = timer
    override fun create() {
        val game = GameKeeper(this, timer)
//        game.prepareAsMan() //no need at this moment, require atlas from other project
        game.mc.connect()
        game.uiskin.prepare() /*load assets fonts + generate styles*/
        game.screenWidth = graphics.width
        game.screenHeight = graphics.height
        
        setScreen(ZeroScreen(game))
    }
}