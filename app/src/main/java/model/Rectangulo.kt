package model

class Rectangulo(var color:Int, var width:Int, var high:Int) {


    //Coordenadas iniciales Pros

    var x:Int=0
    var y:Int=0

    //Métodos(Comportamientos para mover el rectángulo)


    fun moveUp(){
        y-=10
    }

    fun moveDown(){
        y+=10
    }


    fun moveLeft(){
        x-=10
    }

    fun moveRight(){
        x+=10
    }


    //change the size
    fun changeSize(newWith:Int, newHigh:Int){

        width = newWith
        high = newHigh
    }
}