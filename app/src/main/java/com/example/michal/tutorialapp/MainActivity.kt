package com.example.michal.tutorialapp

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import app.Cell

import controller.engineController


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageToShow.setImageBitmap(engineController.image)
       button.setOnClickListener{
           engineController.ySize = ySize.text.toString().toInt()
           engineController.xSize = xSize.text.toString().toInt()
           engineController.nucleonsNumber = nucleonsNumber.text.toString().toInt()
           engineController.arrayToWorkOn = Array(engineController.xSize, { Array(engineController.ySize, { Cell(0, 0, "empty", "empty", 0, false) })})
           updateImage()
           Utils.setGrainsInArray()
           Drawing.setColors()
           println("gcolors set")
           Utils.grainGrow()
           println("grains grow")
           imageToShow.setImageBitmap(Drawing.drawArray())
           println("drawing done")
       }
   }

    fun updateImage() {
        runOnUiThread { imageToShow.setImageBitmap(engineController.image) }
    }
}

