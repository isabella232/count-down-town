package cfg


import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.utils.viewport.Viewport
import io.guthub.healingdrawing.countdowntown.ABC
import saveload.MemoryCard
import colorstepskin.ColorStepSkin
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import timer.GameTimer

class GameKeeper(game: ABC, internal val timer: GameTimer) {
    private val rootGame = game
    
    /**recall to root Game.setScreen*/
    internal var screen = rootGame.screen
        set(value) {
            rootGame.screen = value
            field = value
        }
    
    /**memory card (data storage , between app restart etc)*/
    internal val mc = MemoryCard(this, "countDownTownMemoryCard")
    
    /**add mini pattern textures into asset manager*/
    fun prepareAsMan() {
        asMan.load("w200atlas/w200atlas.atlas", TextureAtlas::class.java)
        asMan.finishLoading()
    }
    
    internal val asMan: AssetManager = AssetManager()
    
    internal val uiskin: ColorStepSkin = ColorStepSkin()
//    internal val uitext = UITextManager()
    
    internal var screenWidth = 1
    internal var screenHeight = 1
    /**extendViewport size of scaled content*/
    internal var worldWidth = 1.0f
    /**extendViewport size of scaled content*/
    internal var worldHeight = 1.0f
    
    /**minimal size for game world content*/
    internal val minWidth = 720f
    /**minimal size for game world content*/
    internal val minHeight = 1280f
    
    /**refresh sizes depend of screen condition*/
    fun refreshSizes(vp: Viewport) {
        screenWidth = vp.screenWidth
        screenHeight = vp.screenHeight
        worldWidth = vp.worldWidth
        worldHeight = vp.worldHeight
        
    }
    
    internal var firstLoading: Boolean = true
        get() = field.also { field = false }
}