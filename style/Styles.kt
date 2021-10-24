package com.example.style

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px
import java.net.URI

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {

//        root{
//            backgroundImage += URI("https://www.jaapsch.net/puzzles/images/hanoi/hanoi.gif")
//        }

        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}