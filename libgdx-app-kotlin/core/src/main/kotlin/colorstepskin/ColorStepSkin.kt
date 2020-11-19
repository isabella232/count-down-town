package colorstepskin

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.ui.Tree.TreeStyle
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle


class ColorStepSkin : Skin() {
    /**x100 colors x3 styles dark acid sun , with hue offset. every next 10... 0 10 20 90 100 is gray. other is hue offset based */
    val cbox = ColorBox()
    
    private val asm:AssetManager = AssetManager()
    var defaultFont:BitmapFont? = null
    var font32:BitmapFont? = null
    var font48:BitmapFont? = null
    var font64:BitmapFont? = null
    var defaultFontFon:BitmapFont? = null
    var font32fon:BitmapFont? = null
    var font48fon:BitmapFont? = null
    var font64fon:BitmapFont? = null
    
    /*styles*/
    /*default*/
    var scroll:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    var split:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    var tree:Array<TreeStyle> = Array(101){TreeStyle()}
    var label:Array<LabelStyle> = Array(101){LabelStyle()}
    var button:Array<ButtonStyle> = Array(101){ButtonStyle()}
    var tbutton:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    var check:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    var tfield:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    var tarea:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    var list:Array<ListStyle> = Array(101){ListStyle()}
    var select:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    var progress:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    var slider:Array<SliderStyle> = Array(101){SliderStyle()}
    var window:Array<WindowStyle> = Array(101){WindowStyle()}
    var tpad:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    var dialog:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*dark*/
    val scrollDark:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitDark:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeDark:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelDark:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonDark:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonDark:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkDark:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listDark:Array<ListStyle> = Array(101){ListStyle()}
    val selectDark:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressDark:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderDark:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowDark:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadDark:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogDark:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*dark text*/
    val scrollTextDark:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitTextDark:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeTextDark:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelTextDark:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonTextDark:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonTextDark:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkTextDark:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldTextDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaTextDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listTextDark:Array<ListStyle> = Array(101){ListStyle()}
    val selectTextDark:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressTextDark:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderTextDark:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowTextDark:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadTextDark:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogTextDark:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*dark fon*/
    val scrollFonDark:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitFonDark:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeFonDark:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelFonDark:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonFonDark:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonFonDark:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkFonDark:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldFonDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaFonDark:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listFonDark:Array<ListStyle> = Array(101){ListStyle()}
    val selectFonDark:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressFonDark:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderFonDark:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowFonDark:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadFonDark:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogFonDark:Array<WindowStyle> = Array(101){WindowStyle()}
    
    
    /*acid*/
    val scrollAcid:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitAcid:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeAcid:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelAcid:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonAcid:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonAcid:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkAcid:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listAcid:Array<ListStyle> = Array(101){ListStyle()}
    val selectAcid:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressAcid:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderAcid:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadAcid:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*acid text*/
    val scrollTextAcid:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitTextAcid:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeTextAcid:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelTextAcid:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonTextAcid:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonTextAcid:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkTextAcid:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldTextAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaTextAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listTextAcid:Array<ListStyle> = Array(101){ListStyle()}
    val selectTextAcid:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressTextAcid:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderTextAcid:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowTextAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadTextAcid:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogTextAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*acid fon*/
    val scrollFonAcid:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitFonAcid:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeFonAcid:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelFonAcid:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonFonAcid:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonFonAcid:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkFonAcid:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldFonAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaFonAcid:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listFonAcid:Array<ListStyle> = Array(101){ListStyle()}
    val selectFonAcid:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressFonAcid:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderFonAcid:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowFonAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadFonAcid:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogFonAcid:Array<WindowStyle> = Array(101){WindowStyle()}
    
    
    /*sun*/
    val scrollSun:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitSun:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeSun:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelSun:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonSun:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonSun:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkSun:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listSun:Array<ListStyle> = Array(101){ListStyle()}
    val selectSun:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressSun:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderSun:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowSun:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadSun:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogSun:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*sun text*/
    val scrollTextSun:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitTextSun:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeTextSun:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelTextSun:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonTextSun:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonTextSun:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkTextSun:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldTextSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaTextSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listTextSun:Array<ListStyle> = Array(101){ListStyle()}
    val selectTextSun:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressTextSun:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderTextSun:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowTextSun:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadTextSun:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogTextSun:Array<WindowStyle> = Array(101){WindowStyle()}
    
    /*sun fon*/
    val scrollFonSun:Array<ScrollPaneStyle> = Array(101){ScrollPaneStyle()}
    val splitFonSun:Array<SplitPaneStyle> = Array(101){SplitPaneStyle()}
    val treeFonSun:Array<TreeStyle> = Array(101){TreeStyle()}
    val labelFonSun:Array<LabelStyle> = Array(101){LabelStyle()}
    val buttonFonSun:Array<ButtonStyle> = Array(101){ButtonStyle()}
    val tbuttonFonSun:Array<TextButtonStyle> = Array(101){TextButtonStyle()}
    val checkFonSun:Array<CheckBoxStyle> = Array(101){CheckBoxStyle()}
    val tfieldFonSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val tareaFonSun:Array<TextFieldStyle> = Array(101){TextFieldStyle()}
    val listFonSun:Array<ListStyle> = Array(101){ListStyle()}
    val selectFonSun:Array<SelectBoxStyle> = Array(101){SelectBoxStyle()}
    val progressFonSun:Array<ProgressBarStyle> = Array(101){ProgressBarStyle()}
    val sliderFonSun:Array<SliderStyle> = Array(101){SliderStyle()}
    val windowFonSun:Array<WindowStyle> = Array(101){WindowStyle()}
    val tpadFonSun:Array<TouchpadStyle> = Array(101){TouchpadStyle()}
    val dialogFonSun:Array<WindowStyle> = Array(101){WindowStyle()}
    
    
    fun prepare(){
        dispose()
        asm.load("color-step-skin/rog32.fnt", BitmapFont::class.java)
        asm.load("color-step-skin/rog48.fnt", BitmapFont::class.java)
        asm.load("color-step-skin/rog64.fnt", BitmapFont::class.java)
    
        asm.load("color-step-skin/color-step-skin.atlas", TextureAtlas::class.java)
        
        asm.load("color-step-skin/inverted/inverted-rog32.fnt", BitmapFont::class.java)
        asm.load("color-step-skin/inverted/inverted-rog48.fnt", BitmapFont::class.java)
        asm.load("color-step-skin/inverted/inverted-rog64.fnt", BitmapFont::class.java)
    
        asm.load("color-step-skin/inverted/inverted-color-step-skin.atlas", TextureAtlas::class.java)
        
        asm.finishLoading()
        
        add("font32", asm.get("color-step-skin/rog32.fnt"), BitmapFont::class.java)
        add("font48", asm.get("color-step-skin/rog48.fnt"), BitmapFont::class.java)
        add("font64", asm.get("color-step-skin/rog64.fnt"), BitmapFont::class.java)
        
        addRegions(asm.get("color-step-skin/color-step-skin.atlas"))
        
        add("font32fon", asm.get("color-step-skin/inverted/inverted-rog32.fnt"), BitmapFont::class.java)
        add("font48fon", asm.get("color-step-skin/inverted/inverted-rog48.fnt"), BitmapFont::class.java)
        add("font64fon", asm.get("color-step-skin/inverted/inverted-rog64.fnt"), BitmapFont::class.java)
        
        addRegions(asm.get("color-step-skin/inverted/inverted-color-step-skin.atlas"))
        
        font32 = get("font32" ,  BitmapFont::class.java)
        font48 = get("font48" ,  BitmapFont::class.java)
        font64 = get("font64" ,  BitmapFont::class.java)
        defaultFont = font32
        
        font32fon = get("font32fon" ,  BitmapFont::class.java)
        font48fon = get("font48fon" ,  BitmapFont::class.java)
        font64fon = get("font64fon" ,  BitmapFont::class.java)
        defaultFontFon = font32fon
        
        createDarkStyle(this)
        createAcidStyle(this)
        createSunStyle(this)
        
        /*default*/
        defaultFonSun() /*short name binded to text sun scheme*/
    }
    
    fun defaultDark(){
        defaultStyle = styleBox.dark
        for (hue in 0..100){
            scroll[hue] = scrollDark[hue]
            split[hue] = splitDark[hue]
            tree[hue] = treeDark[hue]
            label[hue] = labelDark[hue]
            button[hue] = buttonDark[hue]
            tbutton[hue] = tbuttonDark[hue]
            check[hue] = checkDark[hue]
            tfield[hue] = tfieldDark[hue]
            tarea[hue] = tareaDark[hue]
            list[hue] = listDark[hue]
            select[hue] = selectDark[hue]
            progress[hue] = progressDark[hue]
            slider[hue] = sliderDark[hue]
            window[hue] = windowDark[hue]
            tpad[hue] = tpadDark[hue]
            dialog[hue] = dialogDark[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultTextDark(){
        defaultStyle = styleBox.textdark
        for (hue in 0..100){
            scroll[hue] = scrollTextDark[hue]
            split[hue] = splitTextDark[hue]
            tree[hue] = treeTextDark[hue]
            label[hue] = labelTextDark[hue]
            button[hue] = buttonTextDark[hue]
            tbutton[hue] = tbuttonTextDark[hue]
            check[hue] = checkTextDark[hue]
            tfield[hue] = tfieldTextDark[hue]
            tarea[hue] = tareaTextDark[hue]
            list[hue] = listTextDark[hue]
            select[hue] = selectTextDark[hue]
            progress[hue] = progressTextDark[hue]
            slider[hue] = sliderTextDark[hue]
            window[hue] = windowTextDark[hue]
            tpad[hue] = tpadTextDark[hue]
            dialog[hue] = dialogTextDark[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultFonDark(){
        defaultStyle = styleBox.fondark
        for (hue in 0..100){
            scroll[hue] = scrollFonDark[hue]
            split[hue] = splitFonDark[hue]
            tree[hue] = treeFonDark[hue]
            label[hue] = labelFonDark[hue]
            button[hue] = buttonFonDark[hue]
            tbutton[hue] = tbuttonFonDark[hue]
            check[hue] = checkFonDark[hue]
            tfield[hue] = tfieldFonDark[hue]
            tarea[hue] = tareaFonDark[hue]
            list[hue] = listFonDark[hue]
            select[hue] = selectFonDark[hue]
            progress[hue] = progressFonDark[hue]
            slider[hue] = sliderFonDark[hue]
            window[hue] = windowFonDark[hue]
            tpad[hue] = tpadFonDark[hue]
            dialog[hue] = dialogFonDark[hue]
        }
        createDefaultStyle(this)
    }
    
    
    fun defaultAcid(){
        defaultStyle = styleBox.acid
        for (hue in 0..100){
            scroll[hue] = scrollAcid[hue]
            split[hue] = splitAcid[hue]
            tree[hue] = treeAcid[hue]
            label[hue] = labelAcid[hue]
            button[hue] = buttonAcid[hue]
            tbutton[hue] = tbuttonAcid[hue]
            check[hue] = checkAcid[hue]
            tfield[hue] = tfieldAcid[hue]
            tarea[hue] = tareaAcid[hue]
            list[hue] = listAcid[hue]
            select[hue] = selectAcid[hue]
            progress[hue] = progressAcid[hue]
            slider[hue] = sliderAcid[hue]
            window[hue] = windowAcid[hue]
            tpad[hue] = tpadAcid[hue]
            dialog[hue] = dialogAcid[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultTextAcid(){
        defaultStyle = styleBox.textacid
        for (hue in 0..100){
            scroll[hue] = scrollTextAcid[hue]
            split[hue] = splitTextAcid[hue]
            tree[hue] = treeTextAcid[hue]
            label[hue] = labelTextAcid[hue]
            button[hue] = buttonTextAcid[hue]
            tbutton[hue] = tbuttonTextAcid[hue]
            check[hue] = checkTextAcid[hue]
            tfield[hue] = tfieldTextAcid[hue]
            tarea[hue] = tareaTextAcid[hue]
            list[hue] = listTextAcid[hue]
            select[hue] = selectTextAcid[hue]
            progress[hue] = progressTextAcid[hue]
            slider[hue] = sliderTextAcid[hue]
            window[hue] = windowTextAcid[hue]
            tpad[hue] = tpadTextAcid[hue]
            dialog[hue] = dialogTextAcid[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultFonAcid(){
        defaultStyle = styleBox.fonacid
        for (hue in 0..100){
            scroll[hue] = scrollFonAcid[hue]
            split[hue] = splitFonAcid[hue]
            tree[hue] = treeFonAcid[hue]
            label[hue] = labelFonAcid[hue]
            button[hue] = buttonFonAcid[hue]
            tbutton[hue] = tbuttonFonAcid[hue]
            check[hue] = checkFonAcid[hue]
            tfield[hue] = tfieldFonAcid[hue]
            tarea[hue] = tareaFonAcid[hue]
            list[hue] = listFonAcid[hue]
            select[hue] = selectFonAcid[hue]
            progress[hue] = progressFonAcid[hue]
            slider[hue] = sliderFonAcid[hue]
            window[hue] = windowFonAcid[hue]
            tpad[hue] = tpadFonAcid[hue]
            dialog[hue] = dialogFonAcid[hue]
        }
        createDefaultStyle(this)
    }
    
    
    fun defaultSun(){
        defaultStyle = styleBox.sun
        for (hue in 0..100){
            scroll[hue] = scrollSun[hue]
            split[hue] = splitSun[hue]
            tree[hue] = treeSun[hue]
            label[hue] = labelSun[hue]
            button[hue] = buttonSun[hue]
            tbutton[hue] = tbuttonSun[hue]
            check[hue] = checkSun[hue]
            tfield[hue] = tfieldSun[hue]
            tarea[hue] = tareaSun[hue]
            list[hue] = listSun[hue]
            select[hue] = selectSun[hue]
            progress[hue] = progressSun[hue]
            slider[hue] = sliderSun[hue]
            window[hue] = windowSun[hue]
            tpad[hue] = tpadSun[hue]
            dialog[hue] = dialogSun[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultTextSun(){
        defaultStyle = styleBox.textsun
        for (hue in 0..100){
            scroll[hue] = scrollTextSun[hue]
            split[hue] = splitTextSun[hue]
            tree[hue] = treeTextSun[hue]
            label[hue] = labelTextSun[hue]
            button[hue] = buttonTextSun[hue]
            tbutton[hue] = tbuttonTextSun[hue]
            check[hue] = checkTextSun[hue]
            tfield[hue] = tfieldTextSun[hue]
            tarea[hue] = tareaTextSun[hue]
            list[hue] = listTextSun[hue]
            select[hue] = selectTextSun[hue]
            progress[hue] = progressTextSun[hue]
            slider[hue] = sliderTextSun[hue]
            window[hue] = windowTextSun[hue]
            tpad[hue] = tpadTextSun[hue]
            dialog[hue] = dialogTextSun[hue]
        }
        createDefaultStyle(this)
    }
    
    fun defaultFonSun(){
        defaultStyle = styleBox.fonsun
        for (hue in 0..100){
            scroll[hue] = scrollFonSun[hue]
            split[hue] = splitFonSun[hue]
            tree[hue] = treeFonSun[hue]
            label[hue] = labelFonSun[hue]
            button[hue] = buttonFonSun[hue]
            tbutton[hue] = tbuttonFonSun[hue]
            check[hue] = checkFonSun[hue]
            tfield[hue] = tfieldFonSun[hue]
            tarea[hue] = tareaFonSun[hue]
            list[hue] = listFonSun[hue]
            select[hue] = selectFonSun[hue]
            progress[hue] = progressFonSun[hue]
            slider[hue] = sliderFonSun[hue]
            window[hue] = windowFonSun[hue]
            tpad[hue] = tpadFonSun[hue]
            dialog[hue] = dialogFonSun[hue]
        }
        createDefaultStyle(this)
    }
    
    
    /** @return [BitmapFont] used in default styles. Font size 32*/
    val styleFont32 get() = when{fontFon -> font32fon else -> font32 }
    
    /**@param sn style name
     * @return [BitmapFont] depend of style name. Font size 32*/
    fun styleFont32(sn:String) = when{sn.startsWith("fon") || sn[0] in "0123456789" && fontFon -> font32fon else -> font32 }
    
    /** @return [BitmapFont] used in default styles. Font size 48*/
    val styleFont48 get() = when{fontFon -> font48fon else -> font48 }
    
    /**@param sn style name
     * @return [BitmapFont] depend of style name. Font size 48*/
    fun styleFont48(sn:String) = when{sn.startsWith("fon") || sn[0] in "0123456789" && fontFon -> font48fon else -> font48 }
    
    /** @return [BitmapFont] used in default styles. Font size 64*/
    val styleFont64 get() = when{fontFon -> font64fon else -> font64 }
    
    /**@param sn style name
     * @return [BitmapFont] depend of style name. Font size 64*/
    fun styleFont64(sn:String) = when{sn.startsWith("fon") || sn[0] in "0123456789" && fontFon -> font64fon else -> font64 }
    
    /** @return [BitmapFont] used in default styles. Font size is size of used default font*/
    val styleFont get() = when{fontFon -> defaultFontFon else -> defaultFont }
    
    /**@param sn style name
     * @return [BitmapFont] depend of style name. Font size is size of used default font*/
    fun styleFont(sn:String) = when{sn.startsWith("fon") || sn[0] in "0123456789" && fontFon -> defaultFontFon else -> defaultFont }
    
    
    /*font switching*/
    /**available styles list*/
    class StyleBox{
        val dark = 0
        val sun = 1
        val acid = 2
        val textdark = 3
        val textacid = 4
        val textsun = 5
        val fondark = 6
        val fonacid = 7
        val fonsun = 8
    }
    val styleBox = StyleBox()
    private val fonArray = arrayOf(styleBox.fondark, styleBox.fonacid, styleBox.fonsun)
    private val fontFon get() = defaultStyle in fonArray
    
    private var defaultStyle = styleBox.fonsun
    private var backupDefaultStyle = styleBox.fonsun
    /**available fonts list*/
    class FontBox{
        val font32fon = -32
        val font32 = 32
        val font48fon = -48
        val font48 = 48
        val font64fon = -64
        val font64 = 64
    }
    val fontBox = FontBox()
    private var backupDefaultFont = fontBox.font32fon
    
    /**switch styles font to 32, include default fonts*/
    fun useFont32(){
        defaultFont = font32
        defaultFontFon = font32fon
        createDarkStyle(this)
        createAcidStyle(this)
        createSunStyle(this)
        when(defaultStyle){
            styleBox.dark -> defaultDark()
            styleBox.textdark -> defaultTextDark()
            styleBox.fondark -> defaultFonDark()
            styleBox.acid -> defaultAcid()
            styleBox.textacid -> defaultTextAcid()
            styleBox.fonacid -> defaultFonAcid()
            styleBox.sun -> defaultSun()
            styleBox.textsun -> defaultTextSun()
            styleBox.fonsun -> defaultFonSun()
        }
    }
    
    /**switch styles font to 48, include default fonts*/
    fun useFont48(){
        defaultFont = font48
        defaultFontFon = font48fon
        createDarkStyle(this)
        createAcidStyle(this)
        createSunStyle(this)
        when(defaultStyle){
            styleBox.dark -> defaultDark()
            styleBox.textdark -> defaultTextDark()
            styleBox.fondark -> defaultFonDark()
            styleBox.acid -> defaultAcid()
            styleBox.textacid -> defaultTextAcid()
            styleBox.fonacid -> defaultFonAcid()
            styleBox.sun -> defaultSun()
            styleBox.textsun -> defaultTextSun()
            styleBox.fonsun -> defaultFonSun()
        }
    }
    
    /**switch styles font to 64, include default fonts*/
    fun useFont64(){
        defaultFont = font64
        defaultFontFon = font64fon
        createDarkStyle(this)
        createAcidStyle(this)
        createSunStyle(this)
        when(defaultStyle){
            styleBox.dark -> defaultDark()
            styleBox.textdark -> defaultTextDark()
            styleBox.fondark -> defaultFonDark()
            styleBox.acid -> defaultAcid()
            styleBox.textacid -> defaultTextAcid()
            styleBox.fonacid -> defaultFonAcid()
            styleBox.sun -> defaultSun()
            styleBox.textsun -> defaultTextSun()
            styleBox.fonsun -> defaultFonSun()
        }
    }
    
    /*default style section*/
    
    /**set new default style+font values
     * @param styleName value from [ColorStepSkin.styleBox] property
     * @param fontName value from [ColorStepSkin.fontBox] property*/
    fun setDefault(styleName:Int, fontName:Int){
        backupDefaultStyle = styleName
        defaultStyle = styleName
        backupDefaultFont = fontName
        when(fontName){
            fontBox.font32fon, fontBox.font32 -> useFont32()
            fontBox.font48fon, fontBox.font48 -> useFont48()
            fontBox.font64fon, fontBox.font64 -> useFont64()
        }
    }
    /**reset used style to default style. Can be controlled using [setDefaultStyle]*/
    fun useDefault(){
        defaultStyle = backupDefaultStyle
        when(backupDefaultFont){
            fontBox.font32fon, fontBox.font32 -> useFont32()
            fontBox.font48fon, fontBox.font48 -> useFont48()
            fontBox.font64fon, fontBox.font64 -> useFont64()
        }
    }
}