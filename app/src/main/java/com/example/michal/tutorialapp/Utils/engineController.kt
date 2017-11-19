package controller

import android.graphics.Bitmap
import app.*
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by MIachaI on 19.10.2017.
 */

class engineController{

    companion object {

        var xSize: Int = 0
        var ySize: Int = 0
        var nucleonsNumber: Int = 0
        var inclusionsNumber: Int = 0
        var inclusionsSize: Int = 0
        var image: Bitmap = b
        var arrayToWorkOn: Array<Array<Cell>> = Array(xSize, { Array(ySize, { Cell(0, 0, "empty", "empty", 0, false) })})
        var arrayOfColors: Array<Int> = Array(nucleonsNumber,{0})
        var  probabilityOfChange: Int = 0
        var grainsToKeep: Int = 0


/**
        fun getModelxSize() = xSize
        fun setModelxSize(size: Int){xSize = size}

        fun getModelySize() = ySize

        fun setModelySize(size: Int){
            ySize = size

        }

        fun getArray(): Array<Array<Cell>>{
            return arrayToWorkOn
        }
        fun setArray(arrayModel: Array<Array<Cell>>) {
            arrayToWorkOn = arrayModel
        }

        fun getNucleonsNumber(): Int{
            return nucleonsNumber
        }
        fun setNucleonsNumber(numberToSet: Int){
            nucleonsNumber = numberToSet
        }

        fun getInclusionsNumber(): Int{
            return inclusionsNumber
        }
        fun setInclusionsNumber(numberToSet: Int){
            inclusionsNumber = numberToSet
        }

        fun getInclusionsSize(): Int{
            return inclusionsSize
        }
        fun setInclusionsSize(SizeToSet: Int){
            inclusionsSize = SizeToSet
        }

        fun getModelColorArray(): Array<Int>{
           return arrayOfColors
        }
        fun setModelColorArray(arrayToSet: Array<Int>){
            arrayOfColors = arrayToSet
        }
        fun setModelImage(imageToSet: Bitmap){
            image = imageToSet
        }
        fun getModelImage(): Bitmap {
            return image
        }

        fun setModelProbability(probability: Int){
            probabilityOfChange = probability
        }
        fun getModelProbability():Int{
            return probabilityOfChange
        }

        fun setNumberOfSelectedGrains(numberOfGrains: Int){
            grainsToKeep = numberOfGrains
        }
        fun getNumberOfSelectedGrains(): Int{
           return grainsToKeep
        }
        **/
/**      fun setBoundaryDrawing(draw: Boolean){
            boundaryDrawing = draw
        }
        fun getBoundaryDrawing(): Boolean{
            return model.boundaryDrawing.value
        }
        fun setBoundariesToKeep(numberOfBoundaries: Int){
            model.boundariesToKeep = numberOfBoundaries
        }
        fun getBoundariesToKeep(): Int{
            return model.boundariesToKeep.value.toInt()
        }

        fun runSimulation(){
            Utils.grainGrow()


        }
        **/
    }
}