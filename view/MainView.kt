package com.example.view

import javafx.geometry.Pos
import javafx.scene.control.Label
import tornadofx.*
import java.util.*


class MainView : View("Tower Of Hanoi") {

    var time = 0.01



//    fun move(d: javafx.scene.control.Label , i : Int , j : Double)
//    {
//        runLater(j.seconds) {
//            d.resizeRelocate(70.0, i.toDouble(), 0.0, 0.0)
//        }
//    }

//    // Rotate
//    timeline {
//        keyframe(Duration.seconds(3.0)) {
//            keyvalue(d1.rotateProperty(),90.0)
//            keyvalue(d1.rotateProperty(),360.0)
//        }
//    }



    private val d1 = label {
        style = "-fx-background-color: #19EC22 ; -fx-background-radius: 20px"
        text = "1"
        alignment = Pos.CENTER
        setPrefSize(200.0 , 25.0 )
        resizeRelocate(95.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d2 = label {
        style = "-fx-background-color: red ; -fx-background-radius: 20px"
        text = "2"
        alignment = Pos.CENTER
        setPrefSize(200.0 , 25.0 )
        resizeRelocate(375.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d3 = label {
        style = "-fx-background-color: blue ; -fx-background-radius: 20px"
        text = "3"
        alignment = Pos.CENTER
        setPrefSize(200.0 , 25.0 )
        resizeRelocate(655.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d4 = label {
        style = "-fx-background-color: #DEFC21 ; -fx-background-radius: 20px"
        text = "4"
        alignment = Pos.CENTER
        setPrefSize(150.0 , 25.0 )
        resizeRelocate(120.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d5 = label {
        style = "-fx-background-color: #28F9CD ; -fx-background-radius: 20px"
        text = "5"
        alignment = Pos.CENTER
        setPrefSize(150.0 , 25.0 )
        resizeRelocate(400.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d6 = label {
        style = "-fx-background-color: #BA28F9 ; -fx-background-radius: 20px"
        text = "6"
        alignment = Pos.CENTER
        setPrefSize(150.0 , 25.0 )
        resizeRelocate(680.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d7 = label {
        style = "-fx-background-color: #FF2222 ; -fx-background-radius: 20px"
        text = "7"
        alignment = Pos.CENTER
        setPrefSize(100.0 , 25.0 )
        resizeRelocate(145.0 , 325.0 , 0.0 , 0.0 )
    }

    private val d8 = label {
        style = "-fx-background-color: #00FF55 ; -fx-background-radius: 20px"
        text = "8"
        alignment = Pos.CENTER
        setPrefSize(100.0 , 25.0 )
        resizeRelocate(425.0 , 325.0 , 0.0 , 0.0 )
    }

    private val d9 = label {
        style = "-fx-background-color: #FB0291 ; -fx-background-radius: 20px"
        text = "9"
        alignment = Pos.CENTER
        setPrefSize(100.0 , 25.0 )
        resizeRelocate(705.0 , 325.0 , 0.0 , 0.0 )
    }

    private val towerA = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        text = "A"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 30.0 )
        resizeRelocate(70.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineA = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(70.0 , 295.0 , 0.0 , 0.0 )
    }

    private val towerB = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        text = "B"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 30.0 )
        resizeRelocate(350.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineB = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(350.0 , 295.0 , 0.0 , 0.0 )
    }

    private val towerC = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        text = "C"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 30.0 )
        resizeRelocate(630.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineC = label {
        style = "-fx-background-color: white ; -fx-background-radius: 20px"
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(630.0 , 295.0 , 0.0 , 0.0 )
    }

    var diskA = mutableListOf<Int>( 1,4,7 )
    var diskB = mutableListOf<Int>( 2,5,8 )
    var diskC = mutableListOf<Int>( 3,6,9 )

    var counter : Int = 0

    /*
        low = 50
        mid = 25

        1 = 95
        2 = 375
        3 = 655
    */

    // Animation
//       var time : Double = 0.1
//        var width = 250
//        for ( i in 1..100 )
//        {
//            move(d1,width,time)
//            width -= 2
//            time += 0.1
//        }


    private fun move_up_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( disk.layoutX , width , 0.0 , 0.0 ) }
    }


    private fun move_up( disk : javafx.scene.control.Label )
    {
        val count = disk.layoutY - 100
        var width = disk.layoutY
        for ( i in 1..count.toInt() )
        {
            move_up_animation( disk, time, width)
            time += 0.01
            width -= 1
        }

    }

    private fun move_A_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( width , disk.layoutY , 0.0 , 0.0 ) }
    }

    private fun move_A( disk : javafx.scene.control.Label )
    {
        val count = disk.layoutX - 95
        var width = disk.layoutX

        when ( disk.text )
        {
            "1" -> {
                for ( i in 1..count.toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "2" -> {
                for ( i in 1..count.toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "3" -> {
                for ( i in 1..count.toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "4" -> {
                for ( i in 1..(count-25).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "5" -> {
                for ( i in 1..(count-25).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "6" -> {
                for ( i in 1..(count-25).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "7" -> {
                for ( i in 1..(count-50).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "8" -> {
                for ( i in 1..(count-50).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
            "9" -> {
                for ( i in 1..(count-50).toInt() )
                {
                    move_A_animation( disk, time, width)
                    time += 0.01
                    width -= 1
                }
            }
        }
        counter = diskA.size
    }

    private fun move_B_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( width , disk.layoutY , 0.0 , 0.0 ) }
    }

    private fun move_B( disk : javafx.scene.control.Label , origin: String)
    {
        var width = disk.layoutX

        if ( origin == "C" )
        {

            val count = disk.layoutX - 375

            when (disk.text) {
                "1" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "2" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "3" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "4" -> {
                    for (i in 1..(count - 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "5" -> {
                    for (i in 1..(count - 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "6" -> {
                    for (i in 1..(count - 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "7" -> {
                    for (i in 1..(count - 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "8" -> {
                    for (i in 1..(count - 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
                "9" -> {
                    for (i in 1..(count - 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width -= 1
                    }
                }
            }
        }

        if ( origin == "A" )
        {
            val count = 375 - disk.layoutX

            when ( disk.text )
            {
                "1" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "2" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "3" -> {
                    for (i in 1..count.toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "4" -> {
                    for (i in 1..(count + 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "5" -> {
                    for (i in 1..(count + 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "6" -> {
                    for (i in 1..(count + 25).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "7" -> {
                    for (i in 1..(count + 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "8" -> {
                    for (i in 1..(count + 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
                "9" -> {
                    for (i in 1..(count + 50).toInt()) {
                        move_B_animation(disk, time, width)
                        time += 0.01
                        width += 1
                    }
                }
            }





        }

        counter = diskB.size
    }

    private fun move_C_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( width , disk.layoutY , 0.0 , 0.0 ) }
    }

    private fun move_C( disk : javafx.scene.control.Label )
    {
        val count = 655 - disk.layoutX
        var width = disk.layoutX

        when ( disk.text )
        {
            "1" -> {
                for ( i in 1..count.toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "2" -> {
                for ( i in 1..count.toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "3" -> {
                for ( i in 1..count.toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "4" -> {
                for ( i in 1..(count+25).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "5" -> {
                for ( i in 1..(count+25).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "6" -> {
                for ( i in 1..(count+25).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "7" -> {
                for ( i in 1..(count+50).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "8" -> {
                for ( i in 1..(count+50).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
            "9" -> {
                for ( i in 1..(count+50).toInt() )
                {
                    move_C_animation( disk, time, width)
                    time += 0.01
                    width += 1
                }
            }
        }
        counter = diskC.size
    }


    private fun move_down_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( disk.layoutX , width , 0.0 , 0.0 ) }
    }

    private fun move_down( disk : javafx.scene.control.Label , counter : Int )
    {
        val count = 385.0 - (counter * 30) - 100
        var width = 100.0

        for ( i in 1..count.toInt() )
        {
            move_down_animation( disk , time , width )
            time += 0.01
            width += 1
        }

    }


    private fun move( origin : String , target : String )
    {
        var disk = javafx.scene.control.Label()
        when ( origin )
        {
            "A" -> {
                if ( diskA[ diskA.size - 1] == 1 ) { disk = d1 }
                if ( diskA[ diskA.size - 1] == 2 ) { disk = d2 }
                if ( diskA[ diskA.size - 1] == 3 ) { disk = d3 }
                if ( diskA[ diskA.size - 1] == 4 ) { disk = d4 }
                if ( diskA[ diskA.size - 1] == 5 ) { disk = d5 }
                if ( diskA[ diskA.size - 1] == 6 ) { disk = d6 }
                if ( diskA[ diskA.size - 1] == 7 ) { disk = d7 }
                if ( diskA[ diskA.size - 1] == 8 ) { disk = d8 }
                if ( diskA[ diskA.size - 1] == 9 ) { disk = d9 }

                move_up( disk )
                when ( target )
                {
                    "B" -> move_B( disk , "A" )
                    "C" -> move_C( disk )
                }
                move_down( disk , counter )
            }

            "B" -> {
                if ( diskB[ diskB.size - 1] == 1 ) { disk = d1 }
                if ( diskB[ diskB.size - 1] == 2 ) { disk = d2 }
                if ( diskB[ diskB.size - 1] == 3 ) { disk = d3 }
                if ( diskB[ diskB.size - 1] == 4 ) { disk = d4 }
                if ( diskB[ diskB.size - 1] == 5 ) { disk = d5 }
                if ( diskB[ diskB.size - 1] == 6 ) { disk = d6 }
                if ( diskB[ diskB.size - 1] == 7 ) { disk = d7 }
                if ( diskB[ diskB.size - 1] == 8 ) { disk = d8 }
                if ( diskB[ diskB.size - 1] == 9 ) { disk = d9 }

                move_up( disk )
                when ( target )
                {
                    "A" -> move_A( disk )
                    "C" -> move_C( disk )
                }
                move_down( disk , counter )
            }

            "C" -> {
                if ( diskC[ diskC.size - 1] == 1 ) { disk = d1 }
                if ( diskC[ diskC.size - 1] == 2 ) { disk = d2 }
                if ( diskC[ diskC.size - 1] == 3 ) { disk = d3 }
                if ( diskC[ diskC.size - 1] == 4 ) { disk = d4 }
                if ( diskC[ diskC.size - 1] == 5 ) { disk = d5 }
                if ( diskC[ diskC.size - 1] == 6 ) { disk = d6 }
                if ( diskC[ diskC.size - 1] == 7 ) { disk = d7 }
                if ( diskC[ diskC.size - 1] == 8 ) { disk = d8 }
                if ( diskC[ diskC.size - 1] == 9 ) { disk = d9 }


                move_up( disk )
                when ( target )
                {
                    "B" -> move_B( disk , "C" )
                    "C" -> move_C( disk )
                }
                move_down( disk , counter )
            }


        }

    }

    private fun hanoi(disk_A: MutableList<Int>, disk_B: MutableList<Int>, disk_C: MutableList<Int>, number : Int , origin: String , target: String )
    {

        if ( number == 1 )
        {
            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_A[disk_A.size - 1])
                disk_A.removeAt(disk_A.size - 1)
            }
            time += 3

        }
        else
        {
            runLater (time.seconds) {
                hanoi(disk_A, disk_C, disk_B, number - 1, "A", "B")
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_A[disk_A.size - 1])
                disk_A.removeAt(disk_A.size - 1)
            }
            time += 3

            runLater (time.seconds) {
                hanoi(disk_B, disk_A, disk_C, number - 1, "B", "C")
            }
            time += 3

        }

    }

    fun exHanoi( disk_A: MutableList<Int> , disk_B: MutableList<Int> , disk_C: MutableList<Int> , number : Int , origin: String , target: String )
    {

        if ( number == 1 )
        {
            move( origin , target )
            runLater (time.seconds) {
                disk_B.add(disk_C[disk_C.size - 1])
                disk_C.removeAt(disk_C.size - 1)
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_A[disk_A.size - 1])
                disk_A.removeAt(disk_A.size - 1)
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_A.add(disk_B[disk_B.size - 1])
                disk_B.removeAt(disk_B.size - 1)
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_B[disk_B.size - 1])
                disk_B.removeAt(disk_B.size - 1)
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_A[disk_A.size - 1])
                disk_A.removeAt(disk_A.size - 1)
            }
            time += 3

        }
        else
        {
            runLater (time.seconds) {
                exHanoi(disk_A, disk_B, disk_C, number - 1, "A", "C")
            }
            time += 3

            runLater (time.seconds) {
                hanoi(disk_C, disk_A, disk_B, (3 * number) - 2, "C", "B")
            }
            time += 3

            move( origin , target )
            runLater (time.seconds) {
                disk_C.add(disk_A[disk_A.size - 1])
                disk_A.removeAt(disk_A.size - 1)
            }
            time += 3

            runLater (time.seconds) {
                hanoi(disk_B, disk_A, disk_C, (3 * number) - 1, "B", "C")
            }
            time += 3

        }

    }

    override val root = anchorpane {

       setPrefSize(950.0 , 600.0 )
        style = "-fx-background-color: black"

        add(towerA)
        add(lineA)
        add(towerB)
        add(lineB)
        add(towerC)
        add(lineC)
        add(d1)
        add(d2)
        add(d3)
        add(d4)
        add(d5)
        add(d6)
        add(d7)
        add(d8)
        add(d9)

        exHanoi( diskA , diskB , diskC , 3 , "A" , "C" )



    }

}
