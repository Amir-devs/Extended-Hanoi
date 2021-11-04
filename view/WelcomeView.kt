package com.example.view

import javafx.scene.image.Image
import tornadofx.*

class WelcomeView : View("Hanoi")
{

    init {
        setStageIcon( Image("/1.png"))
    }
    var disk_counter = 0


    val l1 = label {

        text = "Welcome to Hanoi "
        style = "-fx-font-size: 50px ; -fx-font-family: \"Times New Roman\", Times, serif;"
        resizeRelocate(280.0 , 30.0 , 0.0 , 0.0)
    }

    val l2 = label {

        text = "number of disks :"
        style = "-fx-font-size: 30px ; -fx-font-family: \"Times New Roman\", Times, serif;"
        resizeRelocate(370.0 , 150.0 , 0.0 , 0.0)
    }

    val t1 = textfield {

        style = "-fx-font-size: 20px ; -fx-font-family: \"Times New Roman\", Times, serif; -fx-background-radius: 10px;" +
                "-fx-background-width: 10px"
        resizeRelocate(370.0 , 200.0 , 0.0 , 0.0)
        setPrefSize(210.0 , 10.0)
    }

    val b1 = button {

        text = "Enter Hanoi World"
        style = "-fx-font-size: 15px ; -fx-font-family: \"Times New Roman\", Times, serif;-fx-background-radius: 10px; "
        resizeRelocate(370.0 , 240.0 , 0.0 , 0.0)
        setPrefSize(210.0 , 10.0)
        action {
            disk_counter = t1.text.toInt()
            val m = MainView()
            m.create_ui( m , disk_counter )
        }
    }

    override val root = anchorpane{

        setPrefSize(950.0 , 600.0 )
        style = "-fx-background-image: url(\"/3.jpg\"); -fx-background-position: center; -fx-background-size: cover"

        add(l1)
        add(l2)
        add(t1)
        add(b1)
    }

}