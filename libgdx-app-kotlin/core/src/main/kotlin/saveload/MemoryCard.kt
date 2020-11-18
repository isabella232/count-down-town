package saveload


import cfg.GameKeeper
import com.badlogic.gdx.Gdx
import kotlin.random.Random

class MemoryCard(private val game: GameKeeper, memoryCardName: String) {
    /**"memory card", for read write game data between restart app etc.*/
    internal val mc = Gdx.app.getPreferences(memoryCardName) /*creation of file will be completed after first save call*/
    
    /**return random string from numbers 0..9 or "" if len <= 0
     * @param len length of resulted string*/
    private fun randNumericString(len:Int):String{
        val allowed = "0123456789"
        var string = ""
        if (len>0) for (i in 0 until len) string += allowed[Random.nextInt(allowed.length)]
        return string
    }
    
    
    /**initialization of memory card(game data storage). Run once per each app start*/
    fun connect() {
        if (!mc.contains("uniKey")) { /*first creation of unique key of app*/
            val uniKey = randNumericString(10)
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
    
    /**brush keys*/
    private val bkeys = arrayOf("rfull", "rSolid", "hue", "lightness")
    
    /**save brush settings to device storage
     * @param fcs force save*/
    fun saveBrush(fcs: Boolean = true) {
        //val b = game.cobox.fbbox.pixbox.continuedBrush
        //val rf = b.rFull
        //val rs = (b.rSolid*100f/rf).toInt() /*convertion to int percentage as in gui used*/
        //val values = arrayOf(rf,rs,b.hue.toInt(),b.lightness.toInt())
        //for (i in bkeys.indices) saveInt(bkeys[i],values[i],false)
        if (fcs) save()
    }
    
    /**load brush settings from device storage*/
    fun loadBrush() {
        var allkeys = true
        for (key in bkeys) if (!mc.contains(key)) {
            allkeys = false; break
        }
        if (allkeys) {
            //val rf = loadInt(bkeys[0])
            //val rs = loadInt(bkeys[1])
            //val hue = loadInt(bkeys[2]).toFloat()
            //val lightness = loadInt(bkeys[3]).toFloat()
            //game.cobox.fbbox.pixbox.continuedBrush.refreshBrush(rf,rs,hue,lightness)
        }
    }
    
    /**shader keys
     * hs - shader hue speed
     * ls - shader lightness speed
     * ho - shader hue offset. For stereo
     * lo - shader lightness offset. For stereo
     * extra - use extra lightness shader amplitude*/
    val skeys = arrayOf("hs", "ls", "ho", "lo", "extra")
    
    /**save shader settings to device storage
     * @param fcs force save*/
    fun saveShader(fcs: Boolean = true) {
        //val c = game.cobox
        //val values = arrayOf(c.hs,c.ls,c.ho,c.lo)
        //for (i in 0..3) saveInt(skeys[i],values[i].toInt(),false)
        //saveBoolean(skeys[4],game.extra, false)
        if (fcs) save()
    }
    
    /**load shader settings from device storage*/
    fun loadShader() {
        var allkeys = true
        for (key in skeys) if (!mc.contains(key)) {
            allkeys = false; break
        }
        if (allkeys) {
            //val hs = loadInt(skeys[0]).toFloat()
            //val ls = loadInt(skeys[1]).toFloat()
            //val ho = loadInt(skeys[2]).toFloat()
            //val lo = loadInt(skeys[3]).toFloat()
            //game.cobox.refreshShader(hs,ls,ho,lo)
            //game.extra = loadBoolean(skeys[4])
        }
    }
    
    fun loadAll() {
        loadBrush(); loadShader()
    }
    
}
