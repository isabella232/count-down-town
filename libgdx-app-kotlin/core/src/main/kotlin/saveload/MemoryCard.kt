package saveload


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import kotlin.random.Random

class MemoryCard(private val game: GameKeeper, memoryCardName: String) {
    /**"memory card", for read write game data between restart app etc.*/
    internal val mc = Gdx.app.getPreferences(memoryCardName) /*creation of file will be completed after first save call*/
    
    /**return random string from numbers 0..9
     * @param len length of resulted string. must be > 0*/
    private fun rns(len:Int) = buildString(len) {
        for (i in 0 until len) append(Random.nextInt(10))
    }
    
    /**initialization of memory card(game data storage). Run once per each app start*/
    fun connect() {
        if (!mc.contains("uniKey")) { /*first creation of unique key of app*/
            val uniKey = rns(10)
            saveString("uniKey", uniKey)
            save()
        }
    }
    
    /** short name to call mc.flush() method, which write data to storage*/
    private fun save() {
        mc.flush()
    }
    
    /**save many values at one call, supported value types is [String] , [Int] , [Float] , [Long] , [Boolean]*/
    fun saveMany(valuesMap: MutableMap<String, *>) {
        mc.put(valuesMap)
    }
    
    /**load all storage data, as [Map]*/
    fun load(): Map<String, *> = mc.get()
    
    fun saveInt(key: String, value: Int, forceSave: Boolean = true) {
        mc.putInteger(key, value); if (forceSave) save()
    }
    
    fun loadInt(key: String) = mc.getInteger(key)
    
    fun saveFloat(key: String, value: Float, forceSave: Boolean = true) {
        mc.putFloat(key, value); if (forceSave) save()
    }
    
    fun loadFloat(key: String) = mc.getFloat(key)
    
    
    fun saveString(key: String, value: String, forceSave: Boolean = true) {
        mc.putString(key, value); if (forceSave) save()
    }
    
    fun loadString(key: String) = mc.getString(key)
    
    fun saveBoolean(key: String, value: Boolean, forceSave: Boolean = true) {
        mc.putBoolean(key, value); if (forceSave) save()
    }
    
    fun loadBoolean(key: String) = mc.getBoolean(key, true)
    
    /**save timers to device storage
     * @param fcs force save*/
    fun saveTimers(fcs: Boolean = true) {
        val timers = game.timers
        var box = ""
        for (i in 0 until timers.size){
            if (timers[i].isNotEmpty()){
                if (box.isNotEmpty()) box += "  "
                box += timers[i]
            }
        }
        saveString("timers", box, false)
        if (fcs) save()
    }
    
    /**load timers from device storage*/
    private fun loadTimers() {
        if (mc.contains("timers")) {
            val box = mc.getString("timers")
            val timers = box.split("  ")
            if (timers[0].isNotEmpty()){
                game.timers = emptyArray()
                for (timer in timers){
                    game.timers += timer
                }
            }
        }
    }
    
    
    /**save used tune to device storage
     * @param fcs force save*/
    fun saveTune(fcs: Boolean = true) {
        val tune = game.timer.tune()
        val repeats = game.timer.repeats()
        val volume = game.tune.volume
        saveString("tune", "$tune", false)
        saveString("repeats", "$repeats", false)
        saveString("volume", "$volume", false)
        if (fcs) save()
    }
    
    /**load used tune from device storage*/
    private fun loadTune() {
        if (mc.contains("tune") && mc.contains("repeats") && mc.contains("volume")) {
            game.timer.tune(mc.getInteger("tune", 1))
            game.timer.repeats(mc.getInteger("repeats", 1))
            game.tune.volume = mc.getFloat("volume", 1f)
        }
    }
    
    
    
    fun loadAll() {
        loadTimers()
        loadTune()
    }
    
}
