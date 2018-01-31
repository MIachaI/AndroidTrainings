package com.example.michal.tutorialapp.Utils

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

        fun changePointsOnPlayerOne(dupa: Int){
            PlayerOnePoints += dupa
        }
    }


}
