package com.example.michal.tutorialapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*
import android.graphics.Bitmap
import android.graphics.Color
import android.widget.ImageView
import app.Cell

import app.b
import controller.engineController


class MainActivity : AppCompatActivity() {

   /** var c = modellingData(xSize.text.toString().toInt(),
            ySize.text.toString().toInt(),
            nucleonsNumber.text.toString().toInt(),
            0,0,
            Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888),
            Array(xSize.text.toString().toInt(), { Array(ySize.text.toString().toInt(), { Cell(0, 0, "empty", "empty", 0, false) })}),
            Array(nucleonsNumber.text.toString().toInt(),{0}),
            0,
            0 )
**/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageToShow.setImageBitmap(engineController.image)
       button.setOnClickListener{
           engineController.ySize = ySize.text.toString().toInt()
           engineController.xSize = xSize.text.toString().toInt()
           engineController.nucleonsNumber = nucleonsNumber.text.toString().toInt()
           engineController.arrayToWorkOn = Array(engineController.xSize, { Array(engineController.ySize, { Cell(0, 0, "empty", "empty", 0, false) })})
           Utils.setGrainsInArray()
           Drawing.setColors()
           println("gcolors set")
           Utils.grainGrow()
           println("grains grow")

           imageToShow.setImageBitmap(Drawing.drawArray())
           println("drawing done")
       }
       decideButton.setOnClickListener{
           engineController.ySize = ySize.text.toString().toInt()
           engineController.xSize = xSize.text.toString().toInt()
       }





        }
    }

