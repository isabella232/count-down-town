package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx.graphics

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class ABC : Game() {
    override fun create() {
        val game = GameKeeper(this)
//        game.prepareAsMan() //no need at this moment, require atlas from other project
        game.mc.connect()
        game.uiskin.prepare() /*load assets fonts + generate styles*/
        game.screenWidth = graphics.width
        game.screenHeight = graphics.height
        
        setScreen(InfoScreen(game))
    }
}