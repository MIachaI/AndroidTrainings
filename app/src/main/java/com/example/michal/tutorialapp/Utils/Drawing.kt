import android.graphics.Bitmap
import controller.engineController



/**
 * Created by MIachaI on 13.10.2017.
 */
class Drawing {

    companion object {
        fun setColors(){
            val arrayOfColors = Array(engineController.nucleonsNumber+1, { 0 })

            for (i in 1..engineController.nucleonsNumber){
                val alpha = (Math.random() * 256).toInt() //alpha
                val red = (Math.random() * 256).toInt() //red
                val green = (Math.random() * 256).toInt() //green
                val blue = (Math.random() * 256).toInt() //blue

                val pixel = 255 shl 24 or (red shl 16) or (green shl 8) or blue
                arrayOfColors[i]=pixel
            }
            arrayOfColors[0] = 0 shl 24 or (0 shl 16) or (0 shl 8) or 0
            engineController.arrayOfColors = arrayOfColors
        }

        fun drawArray(): Bitmap {
            val img = Bitmap.createBitmap(engineController.xSize,engineController.ySize,Bitmap.Config.ARGB_8888)
            for (i in 1..engineController.xSize - 2) {
                for (j in 1..engineController.ySize - 2) {
                    if(engineController.arrayToWorkOn[i][j].cellState=="inclusion"){img.setPixel(i,j,0)}
                    if(engineController.arrayToWorkOn[i][j].cellState=="dual phase"){img.setPixel(i,j,100 shl 24 or (100 shl 16) or (100 shl 8) or 100)}
                    else if (engineController.arrayToWorkOn[i][j].cellState!="empty" && engineController.arrayToWorkOn[i][j].cellState!="")
                    {
                        engineController.arrayToWorkOn[i][j].color = engineController.arrayOfColors[engineController.arrayToWorkOn[i][j].cellState.toInt()]
                        img.setPixel(i, j, engineController.arrayToWorkOn[i][j].color)
                    }
                }
            }
           /** if(engineController.getBoundaryDrawing()){
                Utils.cellsAtBoundary()
                for (i in 1..engineController.xSize - 2) {
                    for (j in 1..engineController.ySize - 2) {
                        if(engineController.arrayToWorkOn[i][j].isBoundary){
                            println("boundary set")
                            img.setPixel(i,j,255 shl 24 or (255 shl 16) or (255 shl 8) or 255)
                        }
                    }
                }
            }**/
            engineController.image = img
            return img
        }

    }
}