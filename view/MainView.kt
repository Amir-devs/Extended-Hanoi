package com.example.view

import javafx.geometry.Pos
import tornadofx.*
import java.util.*


class MainView : View("Tower Of Hanoi") {

    val timer = Timer()



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

    // Animation
//       var time : Double = 0.1
//        var width = 250
//        for ( i in 1..100 )
//        {
//            move(d1,width,time)
//            width -= 2
//            time += 0.1
//        }


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


    fun hanoi( disk_A: MutableList<Int> , disk_B: MutableList<Int> , disk_C: MutableList<Int> , number : Int )
    {
        if ( number == 1 )
        {
            disk_C.add( disk_A[ disk_A.size - 1 ] )
            disk_A.removeAt( disk_A.size - 1 )
        }
        else
        {
            hanoi( disk_A , disk_C , disk_B , number - 1 )
            disk_C.add( disk_A[ disk_A.size - 1 ] )
            disk_A.removeAt( disk_A.size - 1 )
            hanoi( disk_B , disk_A , disk_C, number - 1 )
        }

    }

    fun exHanoi( disk_A: MutableList<Int> , disk_B: MutableList<Int> , disk_C: MutableList<Int> , number : Int )
    {
        if ( number == 1 )
        {
            disk_B.add( disk_C[ disk_C.size - 1 ] )
            disk_C.removeAt( disk_C.size - 1 )
            disk_C.add( disk_A[ disk_A.size - 1 ] )
            disk_A.removeAt( disk_A.size - 1 )
            disk_A.add( disk_B[ disk_B.size - 1 ] )
            disk_B.removeAt( disk_B.size - 1 )
            disk_C.add( disk_B[ disk_B.size - 1 ] )
            disk_B.removeAt( disk_B.size - 1 )
            disk_C.add( disk_A[ disk_A.size - 1 ] )
            disk_A.removeAt( disk_A.size - 1 )
        }
        else
        {
            exHanoi( disk_A, disk_B, disk_C,number - 1 )
            hanoi( disk_C, disk_A, disk_B, (3 * number) - 2 )
            disk_C.add( disk_A[ disk_A.size - 1 ] )
            disk_A.removeAt( disk_A.size - 1 )
            hanoi( disk_B, disk_A, disk_C, (3 * number) - 1 )
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




    }

}
