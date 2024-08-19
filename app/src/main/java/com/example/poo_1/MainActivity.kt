package com.example.poo_1

import android.graphics.Color
import android.os.Bundle
import android.view.Display
import android.view.View
import android.view.WindowMetrics
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rectanguloView:View = findViewById(R.id.viewRectangulo)
        val rectangulo:Rectangulo =Rectangulo(ContextCompat.getColor(this,R.color.red),100,100)


        //configurar el rectangulo para que inicie en el centro

        rectanguloView.post{
            val centerX = (rectanguloView.parent as View).width / 2 - rectangulo.width / 2
            val centerY = (rectanguloView.parent as View).height /2 - rectangulo.high / 2

            rectangulo.x = centerX
            rectangulo.y = centerY

            updateView(rectanguloView,rectangulo)

        }


        val btnTop:Button = findViewById(R.id.btnTop)
        val btnBelow:Button = findViewById(R.id.btnBelow)
        val btnLeft:Button = findViewById(R.id.btnLeft)
        val btnRight:Button = findViewById(R.id.btnRight)
        val btnChangeSize:Button = findViewById(R.id.btnChangeSize)
        val btnChangeColor:Button = findViewById(R.id.btnChangeColor)

        btnTop.setOnClickListener {
            rectangulo.moveUp()
            updateView(rectanguloView,rectangulo)
        }

        btnBelow.setOnClickListener {
            rectangulo.moveDown()

            updateView(rectanguloView,rectangulo)
        }

        btnLeft.setOnClickListener {
            rectangulo.moveLeft()

            updateView(rectanguloView,rectangulo)
        }

        btnRight.setOnClickListener {
            rectangulo.moveRight()

            updateView(rectanguloView,rectangulo)
        }

        btnChangeSize.setOnClickListener {
            rectangulo.changeSize(200,200)

            updateView(rectanguloView,rectangulo)
        }

        btnChangeColor.setOnClickListener {
            // Cambiar el color del rectángulo aleatoriamente
            rectangulo.color = generateRandomColor()
            updateView(rectanguloView, rectangulo)
        }

    }

    // Método para generar un color aleatorio
    private fun generateRandomColor(): Int {
        val random = Random
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return Color.rgb(red, green, blue)
    }

    private fun updateView(rectanguloView:View, rectangulo:Rectangulo){

        rectanguloView.layoutParams.width = rectangulo.width
        rectanguloView.layoutParams.height = rectangulo.high

        rectanguloView.setBackgroundColor(rectangulo.color)

        rectanguloView.x = rectangulo.x.toFloat()
        rectanguloView.y = rectangulo.y.toFloat()

        rectanguloView.requestLayout()


    }
}