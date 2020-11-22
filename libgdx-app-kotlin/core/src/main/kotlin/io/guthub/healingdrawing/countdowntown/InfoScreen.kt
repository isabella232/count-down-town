package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport

/**First displayed screen with text*/
class InfoScreen(private val game: GameKeeper) : ScreenAdapter() {
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val style = "62"
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width, Gdx.graphics.height)
        stage.isDebugAll = false
        
        table.defaults().space(0f).expandY().align(Align.top)
        table.setFillParent(true)
        
        val text = "Text" +
                "\n\nTOUCH THE SCREEN TO BEGIN THE ADVENTURE !" +
                "\n\n\"healingdrawing.github.io\"" +
                "\n2020"
        val info = Label(text, game.uiskin, style)
        info.setAlignment(Align.center)
        info.wrap = true
        info.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.mc.loadAll()
                game.screen = TimerScreen(game)
            }
        })
        table.add(info).fill().expand()
        stage.addActor(table)
        table.setFillParent(true)
    }
    
    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        
        stage.act(delta)
        stage.draw()
    }
    
    private fun refreshSizes(w: Int, h: Int) {
        game.refreshSizes(stage.viewport)
    }
    
    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        stage.viewport.update(width, height, true)
        refreshSizes(stage.viewport.worldWidth.toInt(), stage.viewport.worldHeight.toInt())
    }
}
