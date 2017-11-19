import app.Cell
import app.Moore
import com.example.michal.tutorialapp.MainActivity
import controller.engineController
import java.io.File
import java.io.InputStream
import java.util.*




/**
 * Created by MIachaI on 10.10.2017.
 */
class Utils{

    companion object {

        fun setGrainsInArray(){

            var iterator=1
            val random = Random()
            var array = engineController.arrayToWorkOn
            while(iterator <= engineController.nucleonsNumber) {

                var xSize = random.nextInt(engineController.xSize-2)+1
                var ySize = random.nextInt(engineController.ySize-2)+1
                while (array[xSize][ySize].cellState == "empty") {
                    array[xSize][ySize].cellState = iterator.toString()
                    array[xSize][ySize].cellPreviousState = iterator.toString()
                    iterator++
                }
            }
            engineController.arrayToWorkOn = array
        }

        fun setDiagonalInclusionsBefore() {
            var iterator = 1
            val random = Random()
            var betaArray = engineController.arrayToWorkOn
            while (iterator <= engineController.inclusionsNumber) {
                try {
                    var xSize = random.nextInt(engineController.xSize - 2) + 1
                    var ySize = random.nextInt(engineController.ySize - 2) + 1
                    while (betaArray[xSize][ySize].cellState == "empty")
                        for (i in 0..engineController.inclusionsSize) {
                            for (j in 0..engineController.inclusionsSize) {
                                betaArray[xSize + i][ySize + j].cellState = "inclusion"
                                betaArray[xSize + i][ySize + j].cellPreviousState = "inclusion"
                            }
                        }
                    iterator++
                }
                catch (e: ArrayIndexOutOfBoundsException){
                    println("found error")
                    continue
                }
            }
            engineController.arrayToWorkOn=betaArray
        }
        fun setDiagonalInclusionsAfter(){
            var iterator = 1
            val random = Random()
            var betaArray = engineController.arrayToWorkOn
            while (iterator <= engineController.inclusionsNumber) {
                try {
                    var xSize = random.nextInt(engineController.xSize - 2) + 1
                    var ySize = random.nextInt(engineController.ySize - 2) + 1
                    if (betaArray[xSize][ySize].isBoundary == true) {
                        for (i in 0..engineController.inclusionsSize) {
                            for (j in 0..engineController.inclusionsSize) {
                                betaArray[xSize + i][ySize + j].cellState = "inclusion"
                                betaArray[xSize + i][ySize + j].cellPreviousState = "inclusion"
                            }
                        }
                        iterator++
                    }


                }
                catch (e: ArrayIndexOutOfBoundsException){
                    println("found error")
                    continue
                }
            }
            engineController.arrayToWorkOn=betaArray

        }


        fun setCircleInclusionsBefore(){

            var iterator=1
            val random = Random()
            var betaArray = engineController.arrayToWorkOn
            while(iterator <= engineController.inclusionsNumber) {

                var xSize = random.nextInt(engineController.xSize-2)+1
                var ySize = random.nextInt(engineController.ySize-2)+1
                while (betaArray[xSize][ySize].cellState == "empty") {

                    for (i in -engineController.inclusionsSize..engineController.inclusionsSize){
                        for (j in -engineController.inclusionsSize..engineController.inclusionsSize){
                            if (i*i + j*j <= engineController.inclusionsSize*engineController.inclusionsSize + engineController.inclusionsSize*0.8){
                                try {
                                    betaArray[xSize + i][ySize + j].cellState = "inclusion"
                                    betaArray[xSize + i][ySize + j].cellPreviousState = "inclusion"
                                    println("$xSize $ySize")
                                }
                                catch (e: ArrayIndexOutOfBoundsException){
                                    println("found error")
                                    continue
                                }
                            }
                        }
                    }
                }
                iterator++
            }
            engineController.arrayToWorkOn=betaArray
        }

        fun setCircleInclusionsAfter(){
            var iterator=1

            val random = Random()
            var betaArray = engineController.arrayToWorkOn
            while(iterator <= engineController.inclusionsNumber) {

                var xSize = random.nextInt(engineController.xSize-2)+1
                var ySize = random.nextInt(engineController.ySize-2)+1
                if (betaArray[xSize][ySize].isBoundary == true) {
                    for (i in -engineController.inclusionsSize..engineController.inclusionsSize){
                        for (j in -engineController.inclusionsSize..engineController.inclusionsSize){
                            if (i*i + j*j <= engineController.inclusionsSize*engineController.inclusionsSize + engineController.inclusionsSize*0.8){
                                try {
                                    betaArray[xSize + i][ySize + j].cellState = "inclusion"
                                    betaArray[xSize + i][ySize + j].cellPreviousState = "inclusion"
                                }
                                catch (e: ArrayIndexOutOfBoundsException){
                                    println("found error")
                                    continue
                                }
                            }

                        }

                    }
                    iterator++
                }

            }
            engineController.arrayToWorkOn=betaArray
        }


        fun cellsAtBoundary(){
            var xSize = engineController.xSize
            var ySize = engineController.ySize
            var array = engineController.arrayToWorkOn
            for (i in 1..xSize - 2) {
                for (j in 1..ySize - 2) {
                        try {
                            if (array[i - 1][j].cellPreviousState.equals(array[i][j].cellState)!=true && array[i - 1][j].cellPreviousState.equals("inclusion")!=true) {
                                array[i][j].isBoundary=true
                            }
                            else if (array[i + 1][j].cellPreviousState.equals(array[i][j].cellState)!=true && array[i + 1][j].cellPreviousState.equals("inclusion")!=true) {
                                array[i][j].isBoundary=true
                            }
                            else if (array[i][j - 1].cellPreviousState.equals(array[i][j].cellState)!=true && array[i][j - 1].cellPreviousState.equals("inclusion")!=true) {
                                array[i][j].isBoundary=true
                            }
                            else if (array[i][j + 1].cellPreviousState.equals(array[i][j].cellState)!=true && array[i][j + 1].cellPreviousState.equals("inclusion")!=true) {
                                array[i][j].isBoundary=true
                            }
                        } catch (e: ArrayIndexOutOfBoundsException) {
                            println("error in $i and $j ")
                            continue
                        }
                }
            }
            engineController.arrayToWorkOn=array
        }


        fun grainGrow(){
            var xSize = engineController.xSize
            var ySize = engineController.ySize
            var array = engineController.arrayToWorkOn

            while (true) {
                var buffer = 0
                for (i in 1..xSize - 2) {
                    for (j in 1..ySize - 2) {
                        if (array[i][j].cellPreviousState=="empty") {
                            buffer++
                            try {
                                if (array[i - 1][j].cellPreviousState.equals("empty")!=true && array[i - 1][j].cellPreviousState.equals("inclusion")!=true && array[i - 1][j].cellPreviousState.equals("dual phase")!=true && array[i - 1][j].color ==0) {
                                    array[i][j].cellState = array[i - 1][j].cellPreviousState
                                }
                                else if (array[i + 1][j].cellPreviousState.equals("empty")!=true && array[i + 1][j].cellPreviousState.equals("inclusion")!=true && array[i + 1][j].cellPreviousState.equals("dual phase")!=true && array[i + 1][j].color ==0) {
                                    array[i][j].cellState = array[i + 1][j].cellPreviousState
                                }
                                else if (array[i][j - 1].cellPreviousState.equals("empty")!=true && array[i][j - 1].cellPreviousState.equals("inclusion")!=true && array[i][j - 1].cellPreviousState.equals("dual phase")!=true && array[i][j - 1].color ==0) {
                                    array[i][j].cellState = array[i][j - 1].cellPreviousState
                                }
                                else if (array[i][j + 1].cellPreviousState.equals("empty")!=true && array[i][j + 1].cellPreviousState.equals("inclusion")!=true && array[i][j + 1].cellPreviousState.equals("dual phase")!=true && array[i][j + 1].color ==0) {
                                    array[i][j].cellState = array[i][j + 1].cellPreviousState
                                }
                            } catch (e: ArrayIndexOutOfBoundsException) {
                                println("error in $i and $j ")
                                continue
                            }
                        }
                    }
                }

                for (i in 1..xSize-2){
                    for (j in 1..ySize-2){
                        engineController.arrayToWorkOn[i][j].cellPreviousState = engineController.arrayToWorkOn[i][j].cellState
                    }
                    println(buffer)
                }
                //Drawing.drawArray()
                if(buffer==0) {
                    engineController.arrayToWorkOn=array
                    return
                }
            }
            }


        fun mooreGrowth() {
            var xSize = engineController.xSize
            var ySize = engineController.ySize
            var array = engineController.arrayToWorkOn
            while (true) {
                var buffer = 0
                for (i in 1..xSize - 2) {
                    for (j in 1..ySize - 2) {
                        if (array[i][j].cellPreviousState == "empty") {
                            buffer++
                            try {
                                var temporary = Moore(
                                        array[i - 1][j - 1].cellPreviousState,
                                        array[i - 1][j].cellPreviousState,
                                        array[i - 1][j + 1].cellPreviousState,
                                        array[i][j - 1].cellPreviousState,
                                        array[i][j + 1].cellPreviousState,
                                        array[i + 1][j - 1].cellPreviousState,
                                        array[i + 1][j].cellPreviousState,
                                        array[i + 1][j + 1].cellPreviousState)
                                array[i][j].cellState = temporary.moore()
                            } catch (e: ArrayIndexOutOfBoundsException) {
                                println("error in $i and $j ")
                                continue
                            }
                        }
                    }
                }

                for (i in 1..xSize - 2) {
                    for (j in 1..ySize - 2) {
                        engineController.arrayToWorkOn[i][j].cellPreviousState = engineController.arrayToWorkOn[i][j].cellState
                    }
                }
                println(buffer)
                if (buffer == 0) {
                    engineController.arrayToWorkOn=array
                    return
                }
            }
        }

        fun substructural(){
            var temporaryArray = engineController.arrayToWorkOn
            var numberOfGrainstoKeep = engineController.grainsToKeep
            for (i in 0..engineController.xSize - 1) {
                for (j in 0..engineController.ySize - 1) {
                    if (temporaryArray[i][j].cellState == "empty" || temporaryArray[i][j].cellState == "inclusion" || temporaryArray[i][j].cellState.toInt() <= numberOfGrainstoKeep) {
                        temporaryArray[i][j].cellState = "empty"
                        temporaryArray[i][j].cellPreviousState = "empty"
                    } else {
                        temporaryArray[i][j].color = 1
                        println("substructure set")

                    }
                }
            }
            engineController.arrayToWorkOn=temporaryArray
        }

        fun dualPhase(){
            var temporaryArray = engineController.arrayToWorkOn
            for (i in 0..engineController.xSize - 1) {
                for (j in 0..engineController.ySize - 1) {
                    if(temporaryArray[i][j].cellState!="empty"){
                        temporaryArray[i][j].cellState="dual phase"
                        temporaryArray[i][j].cellPreviousState="dual phase"
                        println("$i $j")
                    }
                }
            }
            engineController.arrayToWorkOn=temporaryArray
        }

        fun clearSpace(){
            var temporaryArray = engineController.arrayToWorkOn
            for (i in 0..engineController.xSize - 1) {
                for (j in 0..engineController.ySize - 1) {
                    if(temporaryArray[i][j].isBoundary!=true){
                        temporaryArray[i][j].cellState="empty"
                        temporaryArray[i][j].cellPreviousState="empty"
                    }
                }
            }
            engineController.arrayToWorkOn=temporaryArray
        }

        fun countPercentageOfBoundariesArea(){
            var temporaryArray = engineController.arrayToWorkOn
            var overallSize = 0
            var boundaries = 0
            for (i in 0..engineController.xSize - 1) {
                for (j in 0..engineController.ySize - 1) {
                    overallSize++
                    if(temporaryArray[i][j].isBoundary){
                        boundaries++
                    }
                }
            }
            println(overallSize/boundaries)
        }

/**
        fun saveToFile(){
            val fileToWrite = File(engineController.getFileToReadPath()+"/export.txt")
            fileToWrite.writeText("${engineController.xSize} ${engineController.ySize} 1 ")
            var stringer = ""
            for (i in 0..engineController.xSize - 1) {
                for (j in 0..engineController.ySize - 1) {
                    stringer+="$i $j 0 ${engineController.arrayToWorkOn[i][j].cellPreviousState} ${engineController.arrayToWorkOn[i][j].cellState} ${engineController.arrayToWorkOn[i][j].color} ${engineController.arrayToWorkOn[i][j].isBoundary} "
                }
                fileToWrite.appendText(stringer)
                stringer=""
            }


        }

        fun writeFromFile(){

            val inputStream: InputStream = File(engineController.getFileToReadPath()).inputStream()
            val inputString = inputStream.bufferedReader().use { it.readText() }
            var inputList = inputString.split(" ")
            engineController.setModelxSize(inputList[0].toInt())
            engineController.setModelySize(inputList[1].toInt())
            var bufferList = inputList.subList(3,inputList.size)
            var testArray = Array(engineController.xSize, {Array(engineController.ySize,{Cell(0,0,"empty","empty",-1,false)})})

             for(x in 0..bufferList.size-5){
                if(x%7==0) {
                    testArray[bufferList[x].toInt()][bufferList[x + 1].toInt()].cellPreviousState = bufferList[x + 3]
                    testArray[bufferList[x].toInt()][bufferList[x + 1].toInt()].cellState = bufferList[x + 4]
                    testArray[bufferList[x].toInt()][bufferList[x + 1].toInt()].color = bufferList[x + 5].toInt()
                    testArray[bufferList[x].toInt()][bufferList[x + 1].toInt()].isBoundary = bufferList[x + 6].toBoolean()
                }
            }
            engineController.setArray(testArray)
        }
        **/
    }
}

