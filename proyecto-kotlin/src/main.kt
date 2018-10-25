var usuario: Usuarios? = null

fun main(args: Array<String>?){

    inicializarProductos()

    val opcionMenu = menuComprador();
    if(opcionMenu == 1){
        val ingresarUsuario = ingresarDatosUsuario()
        UsuariosBDD.agregarUsuario(ingresarUsuario)
        print("\nUsuario agregado con exito...\n")
        print(UsuariosBDD.devolverUsuario())
        main(null)
    }
    else if(opcionMenu == 2){

        realizarCompra()
    }
    else System.exit(0)


    println("\n-------------------------------------------------------------------------------------\n")

}

fun menuComprador(): Int {
    println("\nBIENBENIDO A LA APLICACION DE COMPRAS")
    println("1. Ingresar nuevo usuario")
    println("2. Realizar una compra")
    println("3. Salir");
    val opcion = readLine()!!
    return opcion.toInt()
}

fun ingresarDatosUsuario(): String{
    println("Ingrese su nombre: ")
    val nombreUsuario = readLine()!!
    println("Ingrese su direccion: ")
    val direccionUsuario = readLine()!!
    println("Ingrese su telefono: ")
    val telefonoUsuario = readLine()!!

    val ingresarDatosUsuario = Usuarios(nombreUsuario, direccionUsuario, telefonoUsuario)
    return ingresarDatosUsuario.toString()
}


fun realizarCompra(){
    print(ProductosBDD.devolverProductos())

    print("\nIngrese el ID del producto que desea adquirir: ")
    val idProducto = Integer.parseInt(readLine()!!)
    print("\nIngrese la cantidad: ")
    val cantidadProducto = Integer.parseInt(readLine()!!)

    if(idProducto == 1) print(comprar(1, cantidadProducto))
    else if (idProducto == 2) print(comprar(2, cantidadProducto))
    else if (idProducto == 3) print(comprar(3, cantidadProducto))
    else print("...Producto no existe...")
    main(null)
}

fun comprar(id: Int, cantidadProducto: Int): String {
    return ProductosBDD.comprarProducto(id, cantidadProducto)
}
