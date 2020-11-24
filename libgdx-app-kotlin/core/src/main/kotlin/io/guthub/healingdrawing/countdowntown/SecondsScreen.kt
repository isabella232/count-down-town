package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport

/**Save Load Menu screen with buttons*/
class SecondsScreen(private val game: GameKeeper) : ScreenAdapter() {
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val style = "17"
    private val ray = "sun"
    private val tune = game.tune
    
    private val numberStyle = TextButtonStyle(game.uiskin.get("fon$style$ray", TextButtonStyle::class.java))
    init {
        numberStyle.font = game.uiskin.font64fon
    }
    
    private fun numberCreator(){
        val h = 0..59
        for (i in h){
            val text = if (i>0) "$i" else "s"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    tune.bc()
                    game.timer.s(i)
                    game.screen = TimerScreen(game)
                }
            })
            table.add(b).expand().fill()
            if ((i+1)%6==0 && i<59)table.row()
        }
    }
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width, Gdx.graphics.height)
//        stage.isDebugAll = true
        
        table.defaults().space(0f).expandY().align(Align.top)
        table.setFillParent(true)
        
        numberCreator()
        
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
