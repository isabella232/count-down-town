package tune

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.audio.Music

class TuneManager {
    val asm: AssetManager = AssetManager()
    var prepared:Boolean = false
    
    var click = emptyArray<Music>()
    var clickCoef = emptyArray<Float>()
    var tune = emptyArray<Music>()
    var tuneCoef = emptyArray<Float>()
    
    private enum class states{playing,completed,stopped}
    private var state = states.stopped
    
    /*2020-11-24 fail on desktop, no fixes found, finally hardcoded bottom
    val xfiles = Gdx.files.internal("tunes/").list().size
    */
    val xfiles = 5
    
    fun preload(){
        /*add music files into AssetManager*/
        /*button click*/
        asm.load("bc.ogg", Music::class.java)
        /*tunes*/
        for (i in 0 until xfiles) asm.load("tunes/tune$i.ogg", Music::class.java)
    }
    
    fun prepare(){
        prepared = false
        /*add music tracks from asset manager to music object keeper etc. Not ready at this moment*/
        click += asm.get("bc.ogg", Music::class.java)
        clickCoef += 1f
        for (i in 0 until xfiles){
            tune += asm.get("tunes/tune$i.ogg", Music::class.java)
            tuneCoef += 1f
        }
        prepared = true
    }
    
    /**global game tune volume 0f..1f. Extend to slider controlling limits later*/
    var volume = 0.5f
        set(value) {
            field = when{
                value < 0 -> 0f
                value > 1 -> 1f
                else -> value
            }
        }
    
    /**play timer tune*/
    fun play(tuneNumber:Int, repeats:Int){
        if (isPlaying()) {
            val music = tune[tuneNumber]
            music.volume = volume * tuneCoef[tuneNumber]
            when {
                repeats > 0 -> {
                    music.setOnCompletionListener { play(tuneNumber, repeats - 1) }
                    music.play()
                }
                repeats == -1 -> {
                    music.setOnCompletionListener { play(tuneNumber, -1) }
                    music.play()
                }
                else -> setCompleted()
            }
        }
    }
    fun setPlaying() { state = states.playing}
    fun isPlaying() = state == states.playing
    fun setCompleted(){ state = states.completed}
    fun isCompleted() = state == states.completed
    fun isStopped() = state == states.stopped
    fun stop(){ state = states.stopped }
    
    /**play button click sound*/
    fun bc(){
        val music = click[0]
        music.volume = volume * clickCoef[0]
        music.stop()
        music.play()
    }
}