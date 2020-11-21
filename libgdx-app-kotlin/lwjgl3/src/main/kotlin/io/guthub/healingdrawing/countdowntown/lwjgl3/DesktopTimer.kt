package io.guthub.healingdrawing.countdowntown.lwjgl3

import com.badlogic.gdx.utils.TimeUtils
import timer.GameTimer
import java.text.SimpleDateFormat
import java.util.*

class DesktopTimer : GameTimer(){
    var x = 5
    override fun platformPrint() = println("print declaired on desktop level $x")
    
    
    /**prepared date string*/
//    private fun pds() = SimpleDateFormat("yyyy-MM-dd--hh-mm-ss-SSS").format(Date(TimeUtils.millis()))
    
    private fun hms() = SimpleDateFormat("yyyy-MM-dd--hh-mm-ss-SSS").format(Date(TimeUtils.millis()))
    
    override fun start(){
        when(state){
            states.stopped -> {
                state = states.working
                fullTime()
            }
            
        }
    }
    override fun pause(){}
    override fun resume(){}
    override fun stop(){}
}