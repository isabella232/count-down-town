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


class SaveScreen(private val game:GameKeeper) : ScreenAdapter() {
    private val style = "45"
    private val labelStyle = LabelStyle(game.uiskin.get("text${style}sun",LabelStyle::class.java))
    private val buttonStyle = TextButtonStyle(game.uiskin.get("fon${style}sun",TextButtonStyle::class.java))
    private val scrollStyle = ScrollPaneStyle(game.uiskin.get("text${style}sun",ScrollPaneStyle::class.java))
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val tableHead = Table()
    private val table_scroll: Table = Table()
    private val scroll = ScrollPane(table_scroll, scrollStyle)
    private val table_control: Table = Table()
    private val timers = game.timers
    private var deleted = emptyArray<Int>()
    
    private fun tableHeadCreator(){
        tableHead.defaults().space(20f)
        tableHead.align(Align.top)
    
        tableHead.width = game.worldWidth
        
        val sendInfo = "Not forget about donation..."
        val sendLabel = Label(sendInfo, labelStyle)
        sendLabel.setAlignment(Align.center)
        tableHead.add(sendLabel).fillX().expandX()
    
        tableHead.row()
        val homeText = "OPEN DEVELOPERS SITE TO DONATE"
        val btnHome = TextButton(homeText, buttonStyle)
        btnHome.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                btnHome.isChecked = false
                Gdx.net.openURI("https://healingdrawing.github.io/")
            }
        })
        tableHead.add(btnHome)
    
        tableHead.row()
        val text = "SAVED TIMERS.\n\nTouch to delete timer."
        val vt = Label(text, labelStyle)
        vt.setAlignment(Align.center)
        tableHead.add(vt).fillX().expandX()
    }
    
    private fun table_scroll_creator(){
        table_scroll.defaults().space(20f)
        table_scroll.align(Align.top)
        
        /*patterns code*/
        for (i in 0 until timers.size){
            if (i>0) table_scroll.row()
            val timer = timers[i]
            val b = TextButton(timer, buttonStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isVisible = false
                    deleted += i
                }
            })
            table_scroll.add(b).width(360f)
        }
    }
    
    private fun deleteTimers(){
        for (i in deleted) timers[i] = ""
        var nt = emptyArray<String>()
        for (timer in timers) if (timer.isNotEmpty()) nt += timer
        game.timers = nt.copyOf()
        game.mc.saveTimers()
    }
    fun table_control_creator(){
        table_control.width = game.worldWidth
        table_control.height = 160f
        val bClose = TextButton("CLOSE", buttonStyle)
        bClose.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                deleteTimers()
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
        
        tableHeadCreator()
        table.add(tableHead).fillX().expandX().align(Align.top)
        table.row()
        
        table_scroll_creator()
        
        scroll.setSize(game.worldWidth,game.worldHeight-440f)
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
        tableHead.setSize(game.worldWidth,320f)
        scroll.setSize(game.worldWidth,game.worldHeight-480f)
        table_control.setSize(game.worldWidth, 160f)
    }
    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        stage.viewport.update(width, height, true)
        refreshSizes(stage.viewport.worldWidth.toInt(), stage.viewport.worldHeight.toInt())
    }
}