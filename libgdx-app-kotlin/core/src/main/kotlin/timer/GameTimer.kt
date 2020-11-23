package timer

import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

abstract class GameTimer{
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    enum class states{stopped, working, paused, melody}
    var state = states.stopped
    var h = 0
    var m = 0
    var s = 0
    var fullTime = LocalDateTime.now().plusHours(h.toLong()).plusMinutes(m.toLong()).plusSeconds(s.toLong())
    var pauseTime = LocalTime.now()
    /**tune number*/
    private var tune = 1
    /**tune repeats number -1 is infinity*/
    private var repeats = 1
    
    fun h(hours:Int){if (state == states.stopped) h = hours}
    fun m(minutes:Int){if (state == states.stopped) m = minutes}
    fun s(seconds:Int){if (state == states.stopped) s = seconds}
    fun fullTime(){fullTime = LocalDateTime.now().plusHours(h.toLong()).plusMinutes(m.toLong()).plusSeconds(s.toLong())}
    fun pauseTime(){
        val dt = dt(LocalDateTime.now(), fullTime)
        pauseTime = LocalTime.of(dt.hour, dt.minute, dt.second)
    }
    /**set timer tune*/
    fun tune(number:Int){tune = number}
    /**show used tune number*/
    fun tune() =  tune
    /**set tune repeats number*/
    fun repeats(number:Int){repeats = number}
    /**show tune repeats number*/
    fun repeats() = repeats
    
    
    fun showRepeats() = when(repeats){
        0 -> "mutted"
        -1 -> "looped"
        else -> "times:$repeats"
    }
    fun dts(ts:LocalDateTime,te:LocalDateTime):String{
        val d = Duration.between(ts,te)
        val hours = d.toHours()%24
        val minutes = d.toMinutes()%60
        val seconds = d.seconds%60
        return when{
            d.seconds < 0 -> ""
            else ->  LocalTime.of(hours.toInt(), minutes.toInt(), seconds.toInt()).format(formatter)
        }
    }
    private fun dt(ts:LocalDateTime,te:LocalDateTime):LocalTime{
        val d = Duration.between(ts,te)
        val hours = d.toHours()%24
        val minutes = d.toMinutes()%60
        val seconds = d.seconds%60
        return LocalTime.of(hours.toInt(), minutes.toInt(), seconds.toInt())
    }
    /** export timer settings to string "h m s tune repeats"*/
    fun export():String{
        return "$h $m $s $tune $repeats"
    }
    /**@param et exported (using [export]) timer*/
    fun import(et:String){
        val parsed = et.split(" ")
        h = parsed[0].toInt()
        m = parsed[1].toInt()
        s = parsed[2].toInt()
        tune = parsed[3].toInt()
        repeats = parsed[4].toInt()
    }
    
    abstract fun show():String
    abstract fun start()
    abstract fun pause():String
    abstract fun melody():Boolean
    abstract fun stop()
}