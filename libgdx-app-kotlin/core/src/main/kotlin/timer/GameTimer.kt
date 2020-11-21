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
    
    
    fun h(hours:Int){if (state == states.stopped) h = hours}
    fun m(minutes:Int){if (state == states.stopped) m = minutes}
    fun s(seconds:Int){if (state == states.stopped) s = seconds}
    fun fullTime(){fullTime = LocalDateTime.now().plusHours(h.toLong()).plusMinutes(m.toLong()).plusSeconds(s.toLong())}
    fun startTime(){startTime = LocalTime.now()}
    
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
        println("d.seconds ${d.seconds}")
//        val sum = LocalTime.of(hours.toInt(), minutes.toInt(), seconds.toInt())
        return when{
            d.seconds < 0 -> ""
            else ->  LocalTime.of(hours.toInt(), minutes.toInt(), seconds.toInt()).format(formatter)
        }
    }
    
    abstract fun platformPrint()
    abstract fun start()
    abstract fun pause()
    abstract fun resume()
    abstract fun stop()
}