package com.example.view

import javafx.geometry.Pos
import javafx.scene.control.Label
import tornadofx.*


open class MainView : View("Tower Of Hanoi") {

    var time = 0.01

    var can_move = true
    var index = 0
    var clicked = 0

    val fast_delay = 0.001
    val fast_timer = 1.0

    val normal_delay = 0.003
    val normal_timer = 5.0

    val slow_delay = 0.008
    val slow_timer = 8.0

    var delay = fast_delay
    var timer_delay = fast_timer

    var counter_of_disk = 0

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

    var diskA = mutableListOf<Int>(  )
    var diskB = mutableListOf<Int>(  )
    var diskC = mutableListOf<Int>(  )


    private val disk_style = "-fx-background-color: #FF0070 ; -fx-background-radius: 20px ; -fx-text-fill: black ; "

    private val d1 = label {
         style = disk_style
//        style = "-fx-background-color: #19EC22 ; -fx-background-radius: 20px"
        text = "1"
        alignment = Pos.CENTER
        setPrefSize(200.0 , 25.0 )
        resizeRelocate(95.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d2 = label {
        style = disk_style
//        style = "-fx-background-color: red ; -fx-background-radius: 20px"
        text = "2"
        alignment = Pos.CENTER
        setPrefSize(180.0 , 25.0 )
        resizeRelocate(385.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d3 = label {
        style = disk_style
//        style = "-fx-background-color: #02A0FF ; -fx-background-radius: 20px"
        text = "3"
        alignment = Pos.CENTER
        setPrefSize(160.0 , 25.0 )
        resizeRelocate(675.0 , 385.0 , 0.0 , 0.0 )
    }

    private val d4 = label {
        style = disk_style
//        style = "-fx-background-color: #DEFC21 ; -fx-background-radius: 20px"
        text = "4"
        alignment = Pos.CENTER
        setPrefSize(130.0 , 25.0 )
        resizeRelocate(130.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d5 = label {
        style = disk_style
//        style = "-fx-background-color: #28F9CD ; -fx-background-radius: 20px"
        text = "5"
        alignment = Pos.CENTER
        setPrefSize(110.0 , 25.0 )
        resizeRelocate(420.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d6 = label {
        style = disk_style
//        style = "-fx-background-color: #BA28F9 ; -fx-background-radius: 20px"
        text = "6"
        alignment = Pos.CENTER
        setPrefSize(100.0 , 25.0 )
        resizeRelocate(705.0 , 355.0 , 0.0 , 0.0 )
    }

    private val d7 = label {
        style = disk_style
//        style = "-fx-background-color: #FF2222 ; -fx-background-radius: 20px"
        text = "7"
        alignment = Pos.CENTER
        setPrefSize(90.0 , 25.0 )
        resizeRelocate(150.0 , 325.0 , 0.0 , 0.0 )
    }

    private val d8 = label {
        style = disk_style
//        style = "-fx-background-color: #00FF55 ; -fx-background-radius: 20px"
        text = "8"
        alignment = Pos.CENTER
        setPrefSize(80.0 , 25.0 )
        resizeRelocate(435.0 , 325.0 , 0.0 , 0.0 )
    }

    private val d9 = label {
        style = disk_style
//        style = "-fx-background-color: #FB0291 ; -fx-background-radius: 20px"
        text = "9"
        alignment = Pos.CENTER
        setPrefSize(70.0 , 25.0 )
        resizeRelocate(720.0 , 325.0 , 0.0 , 0.0 )
    }


    val tower_style = "-fx-background-color:  #262323 ; -fx-background-radius: 20px ; -fx-text-fill: white ; -fx-border-color: white ; -fx-border-radius: 20px "
    val line_style = "-fx-background-color: #262323 ; -fx-background-radius: 20px ;  "

    private val towerA = label {

        style = tower_style
        text = "A"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 40.0 )
        resizeRelocate(70.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineA = label {
        style = line_style
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(70.0 , 295.0 , 0.0 , 0.0 )
    }

    private val towerB = label {
        style = tower_style
        text = "B"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 40.0 )
        resizeRelocate(350.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineB = label {
        style = line_style
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(350.0 , 295.0 , 0.0 , 0.0 )
    }

    private val towerC = label {
        style = tower_style
        text = "C"
        alignment = Pos.CENTER
        setPrefSize(250.0 , 40.0 )
        resizeRelocate(630.0 , 420.0 , 0.0 , 0.0 )
    }

    private val lineC = label {
        style = line_style
        alignment = Pos.CENTER
        rotate = 90.0
        setPrefSize(250.0 , 5.0 )
        resizeRelocate(630.0 , 295.0 , 0.0 , 0.0 )
    }

    var origin_list = mutableListOf<String>()
    var target_list = mutableListOf<String>()

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
            time += delay
            width -= 1
        }
    }

    private fun move_A_animation(disk: Label, time: Double, width: Double)
    {
        runLater ( time.seconds ) { disk.resizeRelocate( width , disk.layoutY , 0.0 , 0.0 ) }
    }

    private fun move_A(disk: Label, origin: String)
    {
        var count = disk.layoutX - 95
        var width = disk.layoutX

        if ( origin == "B" )
        {
            when ( disk.text )
            {
                "1" -> {
                    for ( i in 1..count.toInt() )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "2" -> {
                    for ( i in 1..count.toInt()-10 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "3" -> {
                    for ( i in 1..count.toInt()-20 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "4" -> {
                    for ( i in 1..(count-25).toInt()-10 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "5" -> {
                    for ( i in 1..(count-25).toInt()-20 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "6" -> {
                    for ( i in 1..(count-25).toInt()-25 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "7" -> {
                    for ( i in 1..(count-50).toInt()-5 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "8" -> {
                    for ( i in 1..(count-50).toInt()-10 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "9" -> {
                    for ( i in 1..(count-50).toInt()-15 )
                    {
                        move_A_animation( disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
            }

        }
        else if ( origin == "C" ) {

            when (disk.text) {
                "1" -> {
                    for (i in 1..count.toInt()) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "2" -> {
                    for (i in 1..count.toInt() - 10 ) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "3" -> {
                    for (i in 1..count.toInt() - 20) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "4" -> {
                    for (i in 1..(count - 25).toInt() - 10) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "5" -> {
                    for (i in 1..(count - 25).toInt() - 20) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "6" -> {
                    for (i in 1..(count - 25).toInt() - 25 ) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "7" -> {
                    for (i in 1..(count - 50).toInt() - 5 ) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "8" -> {
                    for (i in 1..(count - 50).toInt() - 10) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "9" -> {
                    for (i in 1..(count - 50).toInt() - 15) {
                        move_A_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
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
                    for (i in 1..count.toInt() ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "2" -> {
                    for (i in 1..count.toInt()-10 ) {
                        move_B_animation(disk, time, width)
                        time += delay

                        width -= 1
                    }
                }
                "3" -> {
                    for (i in 1..count.toInt()-20 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "4" -> {
                    for (i in 1..(count - 25).toInt()-10 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "5" -> {
                    for (i in 1..(count - 25).toInt()-20) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "6" -> {
                    for (i in 1..(count - 25).toInt()-25 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "7" -> {
                    for (i in 1..(count - 50).toInt()-5 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "8" -> {
                    for (i in 1..(count - 50).toInt()-10 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width -= 1
                    }
                }
                "9" -> {
                    for (i in 1..(count - 50).toInt()-15 ) {
                        move_B_animation(disk, time, width)
                        time += delay
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
                    for (i in 1..count.toInt() ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "2" -> {
                    for (i in 1..count.toInt()+10 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "3" -> {
                    for (i in 1..count.toInt()+20 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "4" -> {
                    for (i in 1..(count + 25).toInt()+10 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "5" -> {
                    for (i in 1..(count + 25).toInt()+20 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "6" -> {
                    for (i in 1..(count + 25).toInt()+25 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "7" -> {
                    for (i in 1..(count + 50).toInt()+5 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "8" -> {
                    for (i in 1..(count + 50).toInt()+10 ) {
                        move_B_animation(disk, time, width)
                        time += delay
                        width += 1
                    }
                }
                "9" -> {
                    for (i in 1..(count + 50).toInt()+15 ) {
                        move_B_animation(disk, time, width)
                        time += delay
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
                    time += delay
                    width += 1
                }
            }
            "2" -> {
                for ( i in 1..count.toInt()+10 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "3" -> {
                for ( i in 1..count.toInt()+20 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "4" -> {
                for ( i in 1..(count+25).toInt()+10 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "5" -> {
                for ( i in 1..(count+25).toInt()+20 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "6" -> {
                for ( i in 1..(count+25).toInt()+25 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "7" -> {
                for ( i in 1..(count+50).toInt()+5 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "8" -> {
                for ( i in 1..(count+50).toInt()+10 )
                {
                    move_C_animation( disk, time, width)
                    time += delay
                    width += 1
                }
            }
            "9" -> {
                for ( i in 1..(count+50).toInt()+15)
                {
                    move_C_animation( disk, time, width)
                    time += delay
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
            time += delay
            width += 1

            if ( i == count.toInt() )
            {
                time = 0.0
            }
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
                    "B" -> {
                        move_B(disk, "A")
                        diskB.add( diskA[ diskA.size - 1 ] )
                        diskA.removeAt( diskA.size - 1 )
                    }
                    "C" -> {
                        move_C(disk)
                        diskC.add( diskA[ diskA.size - 1 ] )
                        diskA.removeAt( diskA.size - 1 )
                    }
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
                    "A" -> {
                        move_A(disk , origin )
                        diskA.add( diskB[ diskB.size - 1 ] )
                        diskB.removeAt( diskB.size - 1 )
                    }
                    "C" -> {
                        move_C(disk)
                        diskC.add( diskB[ diskB.size - 1 ] )
                        diskB.removeAt( diskB.size - 1 )
                    }
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
                    "B" -> {
                        move_B(disk, "C")
                        diskB.add( diskC[ diskC.size - 1 ])
                        diskC.removeAt( diskC.size - 1 )
                    }
                    "A" -> {
                        move_A(disk, origin)
                        diskA.add( diskC[ diskC.size - 1 ])
                        diskC.removeAt( diskC.size - 1 )
                    }
                }
                move_down( disk , counter )
            }


        }

    }

    private fun hanoi( A : String , B : String , C : String , n : Int )
    {
        if ( n == 1 )
        {
            origin_list.add(A)
            target_list.add(C)
        }
        else
        {
            hanoi( A , C , B , n - 1 )
            origin_list.add(A)
            target_list.add(C)
            hanoi( B , A , C , n - 1 )
        }

    }

    private fun exhanoi( A : String , B : String , C : String , n : Int )
    {
        if ( n == 1 )
        {
            origin_list.add(C)
            target_list.add(B)

            origin_list.add(A)
            target_list.add(C)

            origin_list.add(B)
            target_list.add(A)

            origin_list.add(B)
            target_list.add(C)

            origin_list.add(A)
            target_list.add(C)
        }
        else
        {
            exhanoi( A , B , C ,n - 1 )
            hanoi( C , A , B , (3 * n) - 2 )

            origin_list.add(A)
            target_list.add(C)

            hanoi( B , A , C , (3 * n) - 1 )
        }

    }

    private fun automatic()
    {
        var timer = 0.0
        val onceDo = clicked
        for ( i in index until origin_list.size )
        {
            runLater ( timer.seconds )
            {
                if ( can_move && onceDo == clicked ) {
                    move(origin_list[i], target_list[i])
                    index++

                    process.progress = ( index / 435.0 )
                }
            }
            timer += 0.9
        }
    }

    private fun end()
    {
        clicked++
        can_move = false
        val t = 1
        runLater ( t.seconds )
        {
            d1.resizeRelocate(655.0, 385.0, 0.0, 0.0)
            d2.resizeRelocate(665.0, 355.0, 0.0, 0.0)
            d3.resizeRelocate(675.0, 325.0, 0.0, 0.0)
            d4.resizeRelocate(690.0, 295.0, 0.0, 0.0)
            d5.resizeRelocate(700.0, 265.0, 0.0, 0.0)
            d6.resizeRelocate(705.0, 235.0, 0.0, 0.0)
            d7.resizeRelocate(710.0, 205.0, 0.0, 0.0)
            d8.resizeRelocate(715.0, 175.0, 0.0, 0.0)
            d9.resizeRelocate(720.0, 145.0, 0.0, 0.0)
        }
        index = origin_list.size
        process.progress = ( index / (origin_list.size).toDouble()  )


        when ( counter_of_disk )
        {
            1 -> {
                diskA = mutableListOf( )
                diskB = mutableListOf( )
                diskC = mutableListOf( 1,2,3 )
            }

            2 -> {
                diskA = mutableListOf( )
                diskB = mutableListOf(  )
                diskC = mutableListOf( 1,2,3,4,5,6 )
            }

            3 -> {
                diskA = mutableListOf( )
                diskB = mutableListOf( )
                diskC = mutableListOf( 1,2,3,4,5,6,7,8,9 )
            }
        }

    }

    private fun restart()
    {
        clicked++
        can_move = false
        val t = 1
        runLater ( t.seconds )
        {
            d1.resizeRelocate(95.0 , 385.0 , 0.0 , 0.0 )
            d2.resizeRelocate(385.0 , 385.0 , 0.0 , 0.0 )
            d3.resizeRelocate(675.0 , 385.0 , 0.0 , 0.0 )
            d4.resizeRelocate(130.0 , 355.0 , 0.0 , 0.0 )
            d5.resizeRelocate(420.0 , 355.0 , 0.0 , 0.0 )
            d6.resizeRelocate(705.0 , 355.0 , 0.0 , 0.0 )
            d7.resizeRelocate(150.0 , 325.0 , 0.0 , 0.0 )
            d8.resizeRelocate(435.0 , 325.0 , 0.0 , 0.0 )
            d9.resizeRelocate(720.0 , 325.0 , 0.0 , 0.0 )
        }

        index = 0
        process.progress = ( index / (origin_list.size).toDouble() )

        when ( counter_of_disk )
        {
            1 -> {
                diskA = mutableListOf( 1 )
                diskB = mutableListOf( 2 )
                diskC = mutableListOf( 3 )
            }

            2 -> {
                diskA = mutableListOf( 1,4 )
                diskB = mutableListOf( 2,5 )
                diskC = mutableListOf( 3,6 )
            }

            3 -> {
                diskA = mutableListOf( 1,4,7 )
                diskB = mutableListOf( 2,5,8 )
                diskC = mutableListOf( 3,6,9 )
            }
        }


    }

    private fun resume()
    {
        can_move = true
        var timer = 0.0
        val onceDo = clicked
        for ( i in index until origin_list.size )
        {
            runLater ( timer.seconds )
            {
                if ( can_move && onceDo == clicked )
                {
                    move(origin_list[i], target_list[i])
                    index++
                    process.progress = ( index / (origin_list.size).toDouble())
                }
            }
            timer += timer_delay
        }
    }

    fun next()
    {
        clicked++
        can_move = true
        val onceDo = clicked

        if ( can_move && onceDo == clicked )
        {
            move(origin_list[index], target_list[index])
            index++
            process.progress = ( index / (origin_list.size).toDouble())
        }
    }

    private fun back()
    {
        clicked++
        can_move = true
        val onceDo = clicked

        if ( can_move && onceDo == clicked )
        {
            move(target_list[index-1],origin_list[index-1])
            index--
            process.progress = (( index / (origin_list.size).toDouble() ) )
        }
    }

//    val style_BTN = "-fx-background-color: gray;-fx-text-fill: white;-fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"
    val style_BTN = "-fx-background-color: #404040;-fx-text-fill: white;-fx-effect: innershadow( gaussian , black , 20,0,0,0 ); -fx-background-radius: 20px"

    val process = progressindicator{

        style = "-fx-accent: #FF0070 ; -fx-background-color: #404040 ;-fx-text-fill: blue;-fx-effect: innershadow( gaussian , black , 20,0,0,0 ); -fx-background-radius: 20px ; "
        resizeRelocate(800.0 , 0.0 , 70.0 , 10.0 )
        setPrefSize(150.0 , 150.0)
        paddingAll = 10.0
        progress = 0 / 435.0
    }

    val end_BTN = button {

        style = style_BTN
        text = "End"
        resizeRelocate(760.0 , 500.0 , 30.0 , 10.0 )
        setPrefSize(150.0 , 50.0 )
        action { end() }
    }

    val restart_BTN = button {

        style = style_BTN
        text = "Restart"
        resizeRelocate(600.0 , 500.0 , 30.0 , 10.0 )
        setPrefSize(150.0 , 50.0 )
        action { restart() }
    }

    val back_BTN = button {

        style = style_BTN
        text = "Back"
        resizeRelocate(390.0 , 500.0 , 30.0 , 10.0 )
        setPrefSize(85.0 , 50.0 )
        action { back() }
    }

    val next_BTN = button {

        style = style_BTN
        text = "Next"
        resizeRelocate(480.0 , 500.0 , 30.0 , 10.0 )
        setPrefSize(85.0 , 50.0 )
        action { next() }
    }

    val pause_BTN = button {

        style = style_BTN
        text = "Pause"
        resizeRelocate(240.0 , 500.0 , 30.0 , 10.0 )
        setPrefSize(110.0 , 50.0 )
        action {
            clicked++
            can_move = false
        }
    }

    val resume_BTN = button {

        style = style_BTN
        text = "Automatic"
        resizeRelocate(70.0 , 500.0 , 70.0 , 150.0 )
        setPrefSize(150.0 , 50.0 )
        action { resume() }
    }

    val slow_BTN = button {

        style = style_BTN
        text = "Slow"
        resizeRelocate(800.0 , 160.0 , 30.0 , 10.0 )
        setPrefSize(150.0 , 30.0)
        action {
            delay = slow_delay
            timer_delay = slow_timer
        }
    }

    val normal_BTN = button {

        style = style_BTN
        text = "Normal"
        resizeRelocate(800.0 , 193.0 , 30.0 , 10.0 )
        setPrefSize(150.0 , 30.0)
        action {
            delay = normal_delay
            timer_delay = normal_timer
        }
    }

    val fast_BTN = button {

        style = style_BTN
        text = "Fast"
        resizeRelocate(800.0 , 226.0 , 30.0 , 10.0 )
        setPrefSize(150.0 , 30.0)
        action {
//            delay = fast_delay
//            timer_delay = fast_timer

            this@MainView.close()
            WelcomeView().openWindow()
        }
    }

    fun create_ui( m: MainView, disk_counter: Int)
    {
        counter_of_disk = disk_counter
        when ( disk_counter )
        {
            1 -> onedisk(m)
            2 -> twodisk(m)
            3 -> threedisk(m)
        }
    }

    fun onedisk(m: MainView)
    {
        WelcomeView().close()
        m.openWindow()
        m.add(d1)
        m.add(d2)
        m.add(d3)
        diskA = mutableListOf<Int>( 1 )
        diskB = mutableListOf<Int>( 2 )
        diskC = mutableListOf<Int>( 3 )
        exhanoi( "A" , "B" , "C" , 1 )
        println(origin_list.size)
    }

    fun twodisk(m: MainView)
    {
        WelcomeView().close()
        m.openWindow()
        m.add(d1)
        m.add(d2)
        m.add(d3)
        m.add(d4)
        m.add(d5)
        m.add(d6)
        diskA = mutableListOf<Int>( 1,4 )
        diskB = mutableListOf<Int>( 2,5 )
        diskC = mutableListOf<Int>( 3,6 )
        exhanoi( "A" , "B" , "C" , 2 )
        println(origin_list.size)
    }

    fun threedisk(m: MainView)
    {
        WelcomeView().close()
        m.openWindow()
        m.add(d1)
        m.add(d2)
        m.add(d3)
        m.add(d4)
        m.add(d5)
        m.add(d6)
        m.add(d7)
        m.add(d8)
        m.add(d9)
        diskA = mutableListOf<Int>( 1,4,7 )
        diskB = mutableListOf<Int>( 2,5,8 )
        diskC = mutableListOf<Int>( 3,6,9 )
        exhanoi( "A" , "B" , "C" , 3 )
        println(origin_list.size)
    }


    override var root = anchorpane {

        setPrefSize(950.0 , 600.0 )
        style = "-fx-background-image: url(\"/dark_background.jpg\") "

        add(lineA)
        add(lineB)
        add(lineC)
        add(towerA)
        add(towerB)
        add(towerC)
        add(pause_BTN)
        add(resume_BTN)
        add(next_BTN)
        add(back_BTN)
        add(restart_BTN)
        add(end_BTN)
        add(process)
        add(slow_BTN)
        add(normal_BTN)
        add(fast_BTN)
    }

}
