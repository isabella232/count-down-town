package io.guthub.healingdrawing.countdowntown


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport

/**General Timer Screen*/
class TimerScreen(private val game: GameKeeper) : ScreenAdapter() {
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val style = "17"
    private val ray = "sun"
    
    private val numberStyle = TextButtonStyle(game.uiskin.get("fon$style$ray", TextButtonStyle::class.java))
    private val moreStyle = TextButtonStyle(game.uiskin.get("fon$style$ray", TextButtonStyle::class.java))
    private val displayStyle = LabelStyle(game.uiskin.get("text$style$ray", LabelStyle::class.java))
    private val textStyle = LabelStyle(game.uiskin.get("fon$style$ray", LabelStyle::class.java))
    init {
        numberStyle.font = game.uiskin.font48fon
        moreStyle.font = game.uiskin.font48fon
        displayStyle.font = game.uiskin.font64
        textStyle.font = game.uiskin.font32fon
    }
    
    private fun hoursLeftAreaCreator(){
        val h = arrayOf(0,1,2,3,4,5)
        val t = Table()
        for (i in 0 until h.size){
            val text = if (i>0) "${h[i]}" else "h"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.h(h[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun hoursRightAreaCreator(){
        val h = arrayOf(6,7,8,9,10,11)
        val t = Table()
        for (i in 0 until h.size){
            val text = "${h[i]}"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.h(h[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun hoursCenterAreaCreator(){
        val b = TextButton("more", moreStyle)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.screen = HoursScreen(game)
            }
        })
        table.add(b).size(240f,160f)
    }
    
    private fun minutesLeftAreaCreator(){
        val m = arrayOf(0,1,2,3,5,7)
        val t = Table()
        for (i in 0 until m.size){
            val text = if (i>0) "${m[i]}" else "m"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.m(m[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun minutesRightAreaCreator(){
        val m = arrayOf(10,12,15,20,30,45)
        val t = Table()
        for (i in 0 until m.size){
            val text = "${m[i]}"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.m(m[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun minutesCenterAreaCreator(){
        val b = TextButton("more", moreStyle)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.screen = MinutesScreen(game)
            }
        })
        table.add(b).size(240f,160f)
    }
    
    private fun secondsLeftAreaCreator(){
        val s = arrayOf(0,5,10,15,20,25)
        val t = Table()
        for (i in 0 until s.size){
            val text = if (i>0) "${s[i]}" else "s"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.s(s[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun secondsRightAreaCreator(){
        val s = arrayOf(30,35,40,45,50,55)
        val t = Table()
        for (i in 0 until s.size){
            val text = "${s[i]}"
            val b = TextButton(text, numberStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    b.isChecked = false
                    game.timer.s(s[i])
                }
            })
            t.add(b).height(80f).expandX().fillX()
            if (i==2)t.row()
        }
        table.add(t).expandX().fillX()
    }
    
    private fun secondsCenterAreaCreator(){
        val b = TextButton("more", moreStyle)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.screen = SecondsScreen(game)
            }
        })
        table.add(b).size(240f,160f)
    }
    
    /**timer was paused, or fresh state after stop*/
    private var paused = false
    val displayTimer = Label("00:00:00", displayStyle)
    private fun timerDisplayCreator(){
        displayTimer.setAlignment(Align.center)
        displayTimer.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                game.timer.start()
            }
        })
        table.add(displayTimer).colspan(3).height(240f).fillX().expandX()
    }
    
    val displayText = Label("", textStyle)
    private fun textDisplayCreator(){
        displayText.setText("CountDownTown\nfree citizen\ntimer")
        displayText.setAlignment(Align.center)
        displayText.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked text display")
            }
        })
        table.add(displayText).colspan(3).height(160f).fillX().expandX()
    }
    
    private val tune = game.tune
    private fun saveLoadAreaCreator(){
        val texts = arrayOf("save","dummy","load")
        for (i in 0..2) {
            if (i==1){
                val b = Image(Texture(Gdx.files.internal("cdt.png")))
                b.addListener(object : ClickListener() {
                    override fun clicked(event: InputEvent, x: Float, y: Float) {
                        tune.setPlaying()
                        tune.play(i,1)
                        tune.stop()
                    }
                })
                b.setSize(160f,160f)
                table.add(b).size(160f, 160f)
            }else {
                val b = TextButton(texts[i], moreStyle)
                b.addListener(object : ClickListener() {
                    override fun clicked(event: InputEvent, x: Float, y: Float) {
                        b.isChecked = false
                        when(i){
                            0 -> saveTimer()
                            2 -> game.screen = LoadScreen(game)
                        }
                    }
                })
                table.add(b).height( 160f).expandX().fillX()
            }
        }
    }
    
    private fun stopTuneAreaCreator(){
        val texts = arrayOf("stop","?","tune")
        for (i in 0..2) {
            val b = TextButton(texts[i], moreStyle)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    when(i){
                        0 -> {
                            game.timer.stop()
                            game.tune.stop()
                            b.isChecked = false
                        }
                        2 -> game.screen = TuneScreen(game)
                    }
                }
            })
            if (i==1) table.add(b).size(240f, 160f)
            else table.add(b).height( 160f).expandX().fillX()
        }
    }
    
    private fun saveTimer(){
        game.timers += game.timer.export()
        game.screen = SaveScreen(game)
    }
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width, Gdx.graphics.height)
//        stage.isDebugAll = true
        
        table.defaults().space(0f).expandY().align(Align.top)
        table.setFillParent(true)
        
        hoursLeftAreaCreator()
        hoursCenterAreaCreator()
        hoursRightAreaCreator()
        table.row()
        minutesLeftAreaCreator()
        minutesCenterAreaCreator()
        minutesRightAreaCreator()
        table.row()
        secondsLeftAreaCreator()
        secondsCenterAreaCreator()
        secondsRightAreaCreator()
        table.row()
        timerDisplayCreator()
        table.row()
        textDisplayCreator()
        table.row()
        saveLoadAreaCreator()
        table.row()
        stopTuneAreaCreator()
        
        stage.addActor(table)
        table.setFillParent(true)
    }
    
    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        
        displayTimer.setText(game.timer.show())
        if (game.timer.melody()){
            if (game.tune.isCompleted()){
                game.timer.stop()
                game.tune.stop()
            }
            else if (game.tune.isStopped()){
                game.tune.setPlaying()
                game.tune.play(game.timer.tune(), game.timer.repeats())
            }
        }
        
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
