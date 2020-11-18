package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport

/**Save Load Menu screen with buttons*/
class TimerScreen(private val game: GameKeeper) : ScreenAdapter() {
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val style = "45"
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width, Gdx.graphics.height)
        stage.isDebugAll = true
        
        table.defaults().space(0f).expandY().align(Align.top)
        table.setFillParent(true)
        
        /**banner placeholder. Just background table height of 80px and 100% width*/
        val bt = Table()
        val btl = Label("\" save ... \" menu allows to delete saved patterns", game.uiskin, style)
        btl.setAlignment(Align.center)
        btl.wrap = true
        bt.add(btl).height(80f).align(Align.top).fillX().expandX()
        
        /*buttons table*/
        val butt = Table()
        butt.defaults().space(40f).align(Align.top)
        val btext = arrayOf("button 1", "button 2")
        
        for (i in 0 until btext.size) {
            val b = TextButton(btext[i], game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    when (i) {
                        else -> {
                            println("clicked "+btext[i])
                            //game.screen = TimerScreen(game)
                        }
                    }
        
                    b.isChecked = false
                }
            })
            if (i != 4) butt.add(b)
            else butt.add(b).width(320f)
            if (i < btext.size - 1) butt.row()
            
        }
        
        table.add(bt).fillX().expandX()
        table.row()
        table.add(butt)
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
