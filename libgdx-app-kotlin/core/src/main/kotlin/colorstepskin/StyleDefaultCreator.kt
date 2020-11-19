package colorstepskin

fun createDefaultStyle(css:ColorStepSkin){
    css.apply {
        for (hue in 0..100){
            add("$hue", scroll[hue])
            add("$hue", split[hue])
            add("$hue", tree[hue])
            add("$hue", label[hue])
            add("$hue", button[hue])
            add("$hue", tbutton[hue])
            add("$hue", check[hue])
            add("$hue", tfield[hue])
            add("$hue", tarea[hue])
            add("$hue", list[hue])
            add("$hue", select[hue])
            add("$hue", progress[hue])
            add("$hue", slider[hue])
            add("$hue", window[hue])
            add("$hue", tpad[hue])
            add("$hue", dialog[hue])
        }
    }
}