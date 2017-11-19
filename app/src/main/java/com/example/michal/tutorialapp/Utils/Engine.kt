package app

import com.example.michal.tutorialapp.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Bitmap
import android.graphics.Color
import android.widget.ImageView
import controller.engineController.Companion.xSize
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Created by MIachaI on 19.10.2017.
 */


var b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
data class modellingData( var xSize: Int = 0,
                          var ySize: Int = 0,
                          var nucleonsNumber: Int = 0,
                          var inclusionsNumber: Int = 0,
                          var inclusionsSize:Int = 0,
                          var image: Bitmap = b,
                          var arrayToWorkOn: Array<Array<Cell>>,
                          var arrayOfColors: Array<Int>,
                          var  probabilityOfChange: Int = 0,
                          var grainsToKeep: Int = 0) {

    fun setxSize(dupe: Int){
        xSize = dupe

    }


}
