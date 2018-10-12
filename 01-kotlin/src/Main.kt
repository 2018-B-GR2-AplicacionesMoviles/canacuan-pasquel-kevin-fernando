
//.kt --> formato del archivo
//Se pueden usar los mismos métodos de Java
//Librerias de Java se pueden utilizar
//Se puede colocar o no los ";"

import java.util.Date


fun main(args: Array<String>){
    //System.out.println("Hola mundo")
    println("Hola mundo println")


    //Definir variables

    //Java: Int edad = 1;

    //Kotlin: Variable mutable --> se puede cambiar/reasignar
    var edad = 29 //La variable edad es un entero
    //edad = ""


    //Kotlin: Inmutable --> no puede cambiarse/no se puede resignar
    val edadInmutable: Int = 29


    //Duck Typing --> no se puede ingresar valores que no sean del mismo tipo del sistema

    var curso = 102
    curso = 102

    var nombre = "Kevin"

    //var apellido:Char = "H"
    //apellido = "a"

    var casado = true

    var sueldo = 10.1

    var fechaNacimiento = Date()
    println(fechaNacimiento.toString())

    //WHEN
    when (casado) {
    //false -> println("Feliz" + nombre)	//template strings
        false -> println("Feliz ${nombre}")
    //false -> println("Feliz $nombre")

        true -> println ("Triste")
        else -> {
            println("No me a ejecutar")
            println("Ni yo tampoco")

        }

    }

    var bono = if (casado) 1000.00 else 0.00

    val sueldoTotal = calcularSueldo(bono)
    println(sueldoTotal)

    val kevin = Usuario("Kevin", "Canacuan", "PASQUEL")
    println(kevin)



    println(BaseDeDatos.Usuarios)
    BaseDeDatos.agregarUsuario("Kevin")
    println(BaseDeDatos.Usuarios)

}



// -----------------------------------------------------------

//En kotlin no hay "static"
class BaseDeDatos {

    //companion object  -->
    companion object {
        val Usuarios:ArrayList<String> = ArrayList()

        fun agregarUsuario(nombre: String) {
            Usuarios.add(nombre)
        }

        //Se pueden agregar más métodos
    }
}

// ----------------------------------------------------------

open class Animal(var nombre: String){

}

class Tortuga(nombre: String,
              var pesoCaparazon: Double): Animal(nombre) {
    init {
        println(" $nombre $pesoCaparazon")
    }
}

var animal = Animal(nombre = "Caballo")
var george = Tortuga(nombre = "George", pesoCaparazon = 12.5)

//Por definición todas las clases son "final"; las variables pueden estar definida o ser parámetros
//"init" --> bloque de código que se ejecuta cuando la clase está lista para ejecutarse

class Ejemlpo {
    var nombre:String
    constructor(nNombre:String) {
        println("estoy en el constructor")
        nombre = nNombre
    }
    init {
        println("Estoy en el init")
    }
}

val ejemlpo = Ejemlpo("Kevin")


// -----------------------------------------------------------



//Kotlin --> ayuda a no tener el error del NullPointException
// "?" --> la variable puede ser nula

//CLASES
class Usuario(public var nombre:String){                //Constructor para kotlin (1er constructor)

    public var apellido:String? = null
    public var apellidoMaterno:String? = null

    constructor(vNombre:String, vApellido:String):this(vNombre) {     //2do constructor
        this.apellido = vApellido
    }

    constructor(vNombre:String, vApellido:String, vApellidoMaterno:String):this(vNombre){  //3er constructor
        apellidoMaterno = vApellidoMaterno

    }

    /*constructor(vNombre: String){             //Constructor para java
        this.nombre = vNombre
    }*/

    override fun toString(): String{
        val apellidoMayusculas = if(!apellido.isNullOrBlank()) this.apellido?.toUpperCase() else ""
        val apellidoMaternoMayusculas = if(!apellidoMayusculas.isNullOrBlank()) this.apellidoMaterno?.toUpperCase() else ""
        return "Hola $nombre $apellidoMayusculas $apellidoMaternoMayusculas"
    }

}

//FUNCIONES
// Unit = Void --> no se coloca en funciones que no devuelven nada
fun calcularSueldo(bono:Double): Double {
    var sueldo = 800.00
    return sueldo + bono

}

fun saludar(): Unit {
    println("Hola mundo")
}




