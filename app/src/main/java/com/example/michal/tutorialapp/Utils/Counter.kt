package com.example.michal.tutorialapp.Utils

import android.util.Log
import android.widget.TextView
import com.example.michal.tutorialapp.MainActivity
import com.example.michal.tutorialapp.R

/**
 * Created by Michal on 19.01.2018.
 */
class Counter{
    companion object {
        var PlayerOnePoints = 0
        var PlayerTwoPoints = 0
        var PlayerThreePoints = 0
        var PlayerFourPoints = 0
        var PlayerFivePoints = 0

        fun changePoints(player: Int, points: Int){
            if (player==1){
                PlayerOnePoints+=points
                print("1")
                Log.d("ok?","1")
            }
            if(player==2){
                PlayerTwoPoints+=points
                print("2")
                Log.d("ok?","2")
            }
            if(player==3){
                PlayerThreePoints+=points
                print("3")
                Log.d("ok?","3")
            }
            if(player==4){
                PlayerFourPoints+=points
                print("4")
                Log.d("ok?","4")
            }
            if(player==5){
                PlayerFivePoints+=points
                print("5")
                Log.d("ok?","5")
            }
        }
    }


}
