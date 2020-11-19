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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ExtendViewport

/**Save Load Menu screen with buttons*/
class TimerScreen(private val game: GameKeeper) : ScreenAdapter() {
    private val stage: Stage = Stage()
    private val table: Table = Table()
    private val style = "17"
    
    private fun hoursLeftAreaCreator(){
        val h = arrayOf(0,1,2,3,4,5)
        val t = Table()
        for (i in 0 until h.size){
            val text = if (i>0) "${h[i]}" else "H"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked H${h[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun hoursRightAreaCreator(){
        val h = arrayOf(6,7,8,9,10,11)
        val t = Table()
        for (i in 0 until h.size){
            val text = "${h[i]}"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked H${h[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun hoursCenterAreaCreator(){
        game.uiskin.useFont48()
        val b = TextButton("more", game.uiskin, style)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked more")
                b.isChecked = false
            }
        })
        table.add(b).size(240f,160f)
        game.uiskin.useDefault()
    }
    
    private fun minutesLeftAreaCreator(){
        val m = arrayOf(0,1,2,3,5,7)
        val t = Table()
        for (i in 0 until m.size){
            val text = if (i>0) "${m[i]}" else "M"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked M${m[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun minutesRightAreaCreator(){
        val m = arrayOf(10,12,15,20,30,45)
        val t = Table()
        for (i in 0 until m.size){
            val text = "${m[i]}"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked M${m[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun minutesCenterAreaCreator(){
        game.uiskin.useFont48()
        val b = TextButton("more", game.uiskin, style)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked more")
                b.isChecked = false
            }
        })
        table.add(b).size(240f,160f)
        game.uiskin.useDefault()
    }
    
    private fun secondsLeftAreaCreator(){
        val s = arrayOf(0,5,10,15,20,25)
        val t = Table()
        for (i in 0 until s.size){
            val text = if (i>0) "${s[i]}" else "S"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked S${s[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun secondsRightAreaCreator(){
        val s = arrayOf(30,35,40,45,50,55)
        val t = Table()
        for (i in 0 until s.size){
            val text = "${s[i]}"
            val b = TextButton(text, game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked S${s[i]}")
                    b.isChecked = false
                }
            })
            t.add(b).size(80f)
            if (i==2)t.row()
        }
        table.add(t)
    }
    
    private fun secondsCenterAreaCreator(){
        game.uiskin.useFont48()
        val b = TextButton("more", game.uiskin, style)
        b.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked more")
                b.isChecked = false
            }
        })
        table.add(b).size(240f,160f)
        game.uiskin.useDefault()
    }
    
    /**timer was paused, or fresh state after stop*/
    private var paused = false
    val displayTimer = Label("00:00:00", game.uiskin, style)
    private fun timerDisplayCreator(){
        game.uiskin.defaultTextSun()
        game.uiskin.useFont64()
        displayTimer.style = game.uiskin.get(style, LabelStyle::class.java)
        displayTimer.setAlignment(Align.center)
        displayTimer.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked timer display")
            }
        })
        table.add(displayTimer).colspan(3).height(240f).fillX().expandX()
        game.uiskin.useDefault()
    }
    
    val displayText = Label("", game.uiskin, style)
    private fun textDisplayCreator(){
        displayText.setText("CountDownTown\nfree citizen\ntimer")
        displayText.setAlignment(Align.center)
//        displayText.style = game.uiskin.get(style, LabelStyle::class.java)
        displayText.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("clicked text display")
            }
        })
        table.add(displayText).colspan(3).height(160f).fillX().expandX()
    }
    
    private fun saveLoadAreaCreator(){
        game.uiskin.useFont48()
        val texts = arrayOf("save","dummy","load")
        for (i in 0..2) {
            if (i==1){
                val b = Image(Texture(Gdx.files.internal("cdt.png")))
                b.setSize(160f,160f)
                b.addListener(object : ClickListener() {
                    override fun clicked(event: InputEvent, x: Float, y: Float) {
                        println("clicked ${texts[i]}")
                    }
                })
                table.add(b).size(160f, 160f)
            }else {
                val b = TextButton(texts[i], game.uiskin, style)
                b.addListener(object : ClickListener() {
                    override fun clicked(event: InputEvent, x: Float, y: Float) {
                        println("clicked ${texts[i]}")
                        b.isChecked = false
                    }
                })
                table.add(b).size(240f, 160f)
            }
        }
    }
    
    private fun stopSoundAreaCreator(){
        val texts = arrayOf("stop","?","tune")
        for (i in 0..2) {
            val b = TextButton(texts[i], game.uiskin, style)
            b.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    println("clicked ${texts[i]}")
                    b.isChecked = false
                }
            })
            table.add(b).size(240f, 160f)
        }
        game.uiskin.useDefault()
    }
    
    
    override fun show() {
        super.show()
        Gdx.input.inputProcessor = stage
        stage.viewport = ExtendViewport(game.minWidth, game.minHeight)
        resize(Gdx.graphics.width, Gdx.graphics.height)
//        stage.isDebugAll = true
        
        table.defaults().space(0f).expandY().align(Align.top)
        table.setFillParent(true)
        
        game.uiskin.setDefault(game.uiskin.styleBox.fonsun, game.uiskin.fontBox.font32fon) //just testing, work
        
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
        stopSoundAreaCreator()
        
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
