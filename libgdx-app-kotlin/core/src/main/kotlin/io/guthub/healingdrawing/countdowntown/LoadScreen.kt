package io.guthub.healingdrawing.countdowntown

import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport


class LoadScreen(private val game:GameKeeper) : ScreenAdapter() {
    private val style = "45"
    private val labelStyle = LabelStyle(game.uiskin.get("text${style}sun",LabelStyle::class.java))
    private val buttonStyle = TextButtonStyle(game.uiskin.get("fon${style}sun",TextButtonStyle::class.java))
    private val scrollStyle = ScrollPaneStyle(game.uiskin.get("text${style}sun", ScrollPaneStyle::class.java))
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val table_scroll: Table = Table()
    private val scroll = ScrollPane(table_scroll, scrollStyle)
    private val table_control: Table = Table()
    private val timers = game.timers
    
    private fun table_scroll_creator(){
        table_scroll.defaults().space(20f)
        
        val sendInfo = "Your support is important ! \n" +
                "To interesting things appeared \n" +
                "no need to be shy ..."
        val sendLabel = Label(sendInfo, labelStyle)
        sendLabel.wrap = true
        sendLabel.setAlignment(Align.center)
        table_scroll.add(sendLabel).fillX()
        
        table_scroll.row()
        val homeText = "OPEN DEVELOPERS SITE TO DONATE"
        val btnHome = TextButton(homeText, buttonStyle)
        btnHome.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                btnHome.isChecked = false
                Gdx.net.openURI("https://healingdrawing.github.io/")
            }
        })
        table_scroll.add(btnHome)
        
        table_scroll.row()
        val text = "Touch to load timer."
        val vt = Label(text, labelStyle)
        vt.setAlignment(Align.center)
        table_scroll.add(vt).fillX().expandX()
        
        /*patterns code*/
        for (i in 0 until timers.size){
            table_scroll.row()
            val timer = timers[i]
            val b = TextButton(timer, buttonStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    game.timer.import(timer)
                    game.screen = TimerScreen(game)
                }
            })
            table_scroll.add(b).width(360f)
        }
    }
    
    fun table_control_creator(){
        val bClose = TextButton("CLOSE", buttonStyle)
        bClose.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.screen = TimerScreen(game)
            }
        })
        table_control.defaults().space(40f)
        table_control.add(bClose)
    }
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width,Gdx.graphics.height)
//        stage.isDebugAll = true
        table.defaults().space(20f)
        
        table_scroll_creator()
        
        scroll.setSize(game.worldWidth,game.worldHeight-160f)
        scroll.setScrollingDisabled(true,false)
        scroll.setCancelTouchFocus(false)
        scroll.setScrollbarsOnTop(true)
        table.add(scroll).align(Align.top).expand().fill()
        table.row()
        table_control_creator()
        table.add(table_control).height(160f)
        
        
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
    
    private fun refreshSizes(w:Int,h:Int){
        game.refreshSizes(stage.viewport)
        scroll.setSize(game.worldWidth,game.worldHeight-160f)
        table_control.setSize(game.worldWidth, 160f)
    }
    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        stage.viewport.update(width, height, true)
        refreshSizes(stage.viewport.worldWidth.toInt(), stage.viewport.worldHeight.toInt())
    }
}