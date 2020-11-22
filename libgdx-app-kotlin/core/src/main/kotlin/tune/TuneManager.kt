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
    private val xfiles = Gdx.files.local("tunes/").list().size
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
    var volume = 1f
        set(value) {
            field = when{
                value < 0 -> 0f
                value > 1 -> 1f
                else -> value
            }
        }
    var looped = false
    /**play timer tune*/
    fun play(tuneNumber:Int, repeats:Int){
        val music = tune[tuneNumber]
        music.volume = volume * tuneCoef[tuneNumber]
        if (repeats > 0){
            music.setOnCompletionListener { Music.OnCompletionListener { play(tuneNumber,repeats-1) } }
            music.play()
        }
        else if (repeats == -1 && looped){
            music.setOnCompletionListener { Music.OnCompletionListener { play(tuneNumber,-1) } }
            music.play()
        }
    }
}