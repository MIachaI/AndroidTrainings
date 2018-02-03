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
            Counter.changePoints(1,-1)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOneMinusFiveButton = findViewById<Button>(R.id.button2)
        playerOneMinusFiveButton.setOnClickListener {
            Counter.changePoints(1,-5)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOnePlusOneButton = findViewById<Button>(R.id.button3)
        playerOnePlusOneButton.setOnClickListener {
            Counter.changePoints(1,1)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }
        val playerOnePlusFiveButton = findViewById<Button>(R.id.button4)
        playerOnePlusFiveButton.setOnClickListener {
            Counter.changePoints(1, 5)
            playerOnePoints.text = Counter.PlayerOnePoints.toString()
        }


        val playerTwoPoints = findViewById<TextView>(R.id.textView2)
        val playerTwoMinusOneButton = findViewById<Button>(R.id.button5)
        playerTwoMinusOneButton.setOnClickListener {
            Counter.changePoints(2,-1)
            playerTwoPoints.text = Counter.PlayerTwoPoints.toString()
        }
        val playerTwoMinusFiveButton = findViewById<Button>(R.id.button6)
        playerTwoMinusFiveButton.setOnClickListener {
            Counter.changePoints(2,-5)
            playerTwoPoints.text = Counter.PlayerTwoPoints.toString()
        }
        val playerTwoPlusOneButton = findViewById<Button>(R.id.button7)
        playerTwoPlusOneButton.setOnClickListener {
            Counter.changePoints(2,1)
            playerTwoPoints.text = Counter.PlayerTwoPoints.toString()
        }
        val playerTwoPlusFiveButton = findViewById<Button>(R.id.button8)
        playerTwoPlusFiveButton.setOnClickListener {
            Counter.changePoints(2,5)
            playerTwoPoints.text = Counter.PlayerTwoPoints.toString()
        }


        val playerThreePoints = findViewById<TextView>(R.id.textView3)
        val playerThreeMinusOneButton = findViewById<Button>(R.id.button9)
        playerThreeMinusOneButton.setOnClickListener {
            Counter.changePoints(3,-1)
            playerThreePoints.text = Counter.PlayerThreePoints.toString()
        }
        val playerThreeMinusFiveButton = findViewById<Button>(R.id.button10)
        playerThreeMinusFiveButton.setOnClickListener {
            Counter.changePoints(3,-5)
            playerThreePoints.text = Counter.PlayerThreePoints.toString()
        }
        val playerThreePlusOneButton = findViewById<Button>(R.id.button11)
        playerThreePlusOneButton.setOnClickListener {
            Counter.changePoints(3,1)
            playerThreePoints.text = Counter.PlayerThreePoints.toString()
        }
        val playerThreePlusFiveButton = findViewById<Button>(R.id.button12)
        playerThreePlusFiveButton.setOnClickListener {
            Counter.changePoints(3,5)
            playerThreePoints.text = Counter.PlayerThreePoints.toString()
        }



        val playerFourPoints = findViewById<TextView>(R.id.textView4)
        val playerFourMinusOneButton = findViewById<Button>(R.id.button13)
        playerFourMinusOneButton.setOnClickListener {
            Counter.changePoints(4,-1)
            playerFourPoints.text = Counter.PlayerFourPoints.toString()
        }
        val playerFourMinusFiveButton = findViewById<Button>(R.id.button14)
        playerFourMinusFiveButton.setOnClickListener {
            Counter.changePoints(4,-5)
            playerFourPoints.text = Counter.PlayerFourPoints.toString()
        }
        val playerFourPlusOneButton = findViewById<Button>(R.id.button15)
        playerFourPlusOneButton.setOnClickListener {
            Counter.changePoints(4,1)
            playerFourPoints.text = Counter.PlayerFourPoints.toString()
        }
        val playerFourPlusFiveButton = findViewById<Button>(R.id.button16)
        playerFourPlusFiveButton.setOnClickListener {
            Counter.changePoints(4,5)
            playerFourPoints.text = Counter.PlayerFourPoints.toString()
        }


        val playerFivePoints = findViewById<TextView>(R.id.textView5)
        val playerFiveMinusOneButton = findViewById<Button>(R.id.button17)
        playerFiveMinusOneButton.setOnClickListener {
            Counter.changePoints(5,-1)
            playerFivePoints.text = Counter.PlayerFivePoints.toString()
        }
        val playerFiveMinusFiveButton = findViewById<Button>(R.id.button18)
        playerFiveMinusFiveButton.setOnClickListener {
            Counter.changePoints(5,-5)
            playerFivePoints.text = Counter.PlayerFivePoints.toString()
        }
        val playerFivePlusOneButton = findViewById<Button>(R.id.button19)
        playerFivePlusOneButton.setOnClickListener {
            Counter.changePoints(5,1)
            playerFivePoints.text = Counter.PlayerFivePoints.toString()
        }
        val playerFivePlusFiveButton = findViewById<Button>(R.id.button20)
        playerFivePlusFiveButton.setOnClickListener {
            Counter.changePoints(5,5)
            playerFivePoints.text = Counter.PlayerFivePoints.toString()
        }


   }
}




