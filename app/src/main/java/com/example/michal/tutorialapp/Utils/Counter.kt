package com.example.michal.tutorialapp.Utils

import android.widget.TextView
import com.example.michal.tutorialapp.MainActivity
import com.example.michal.tutorialapp.R

/**
 * Created by Michal on 19.01.2018.
 */
public class Counter{
    companion object {
        var PlayerOnePoints = 0
        var PlayerTwoPoints = 0
        var PlayerThreePoints = 0
        var PlayerFourPoints = 0
        var PlayerFivePoints = 0

        fun changePoints(player: Int, points: Int){
            if (player==1){
                PlayerOnePoints+=points
            }
        }

        fun buttonAction(player: Int, points: Int){

            val playerOnePoints = MainActivity.findViewById<TextView>(R.id.textView1)

        }
    }


}
