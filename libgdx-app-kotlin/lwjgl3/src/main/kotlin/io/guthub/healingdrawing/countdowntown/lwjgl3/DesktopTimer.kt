package io.guthub.healingdrawing.countdowntown.lwjgl3

import timer.GameTimer

class DesktopTimer : GameTimer(){
    override fun platformPrint() = println("print declaired on desktop level")
}