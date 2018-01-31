package com.example.michal.tutorialapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.michal.tutorialapp.Utils.Counter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playerOnePoints = findViewById<TextView>(R.id.textView1)
        val playerOneMinusOneButton = findViewById<Button>(R.id.button1)
        playerOneMinusOneButton.setOnClickListener {
            Counter.changePointsOnPlayerOne(-1)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOneMinusFiveButton = findViewById<Button>(R.id.button2)
        playerOneMinusFiveButton.setOnClickListener {
            Counter.changePointsOnPlayerOne(-5)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOnePlusOneButton = findViewById<Button>(R.id.button3)
        playerOnePlusOneButton.setOnClickListener {
            Counter.changePointsOnPlayerOne(1)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOnePlusFiveButton = findViewById<Button>(R.id.button4)
        playerOnePlusFiveButton.setOnClickListener {
            Counter.changePointsOnPlayerOne(5)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }


       }
   }




