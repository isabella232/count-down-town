package timer

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

abstract class GameTimer{
    private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    enum class states{stopped, working, paused, melody}
    var state = states.stopped
    private var h = 0
    private var m = 0
    private var s = 0
    private var fullTime = LocalDateTime.now().plusHours(h.toLong()).plusMinutes(m.toLong()).plusSeconds(s.toLong())
    private var startTime = LocalTime.now()
    /**tune number 0 is silence*/
    private var tune = 1
    /**tune repeats number -1 is infinity*/
    private var repeats = 1
    
    fun h(hours:Int){if (state == states.stopped) h = hours}
    fun m(minutes:Int){if (state == states.stopped) m = minutes}
    fun s(seconds:Int){if (state == states.stopped) s = seconds}
    fun fullTime(){fullTime = LocalDateTime.now().plusHours(h.toLong()).plusMinutes(m.toLong()).plusSeconds(s.toLong())}
    /**set timer tune*/
    fun tune(number:Int){tune = number}
    /**show used tune number*/
    fun tune() =  tune
    /**set tune repeats number*/
    fun repeats(number:Int){repeats = number}
    /**show tune repeats number*/
    fun repeats() = repeats
    
    fun show():String = when(state){
        states.stopped -> LocalTime.of(h,m,s).format(formatter)
        states.working -> {
            val text = dts(LocalDateTime.now(),fullTime)
            if (text == "") state = states.stopped
            text
        }
        else -> "bang"
    }
    
    private fun dts(ts:LocalDateTime,te:LocalDateTime):String{
        val d = Duration.between(ts,te)
        val hours = d.toHours()%24
        val minutes = d.toMinutes()%60
        val seconds = d.seconds%60
        return when{
            d.seconds < 0 -> ""
            else ->  LocalTime.of(hours.toInt(), minutes.toInt(), seconds.toInt()).format(formatter)
        }
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
    
    abstract fun platformPrint()
    abstract fun start()
    abstract fun pause()
    abstract fun resume()
    abstract fun stop()
}