import java.util.ArrayList


    val nombreProductos1 = "PAPAS"
    val precioProductos1 = 20.5
    var stockProductos1 = 2
    val nombreProductos2 = "MANZANAS"
    val precioProductos2 = 5.2
    var stockProductos2 = 10
    val nombreProductos3 = "CARNE"
    val precioProductos3 = 15.40
    var stockProductos3 = 12

fun inicializarProductos() {
    ProductosBDD.removeAll()
    val ingresarDatosProductos1 = Productos(nombreProductos1, precioProductos1, stockProductos1)
    ProductosBDD.agregarProducto(ingresarDatosProductos1.toString())
    val ingresarDatosProductos2 = Productos(nombreProductos2, precioProductos2, stockProductos2)
    ProductosBDD.agregarProducto(ingresarDatosProductos2.toString())
    val ingresarDatosProductos3 = Productos(nombreProductos3, precioProductos3, stockProductos3)
    ProductosBDD.agregarProducto(ingresarDatosProductos3.toString())
}

fun ingresarCompra() {
    ProductosBDD.removeAll()
    val ingresarDatosProductos1 = Productos(nombreProductos1, precioProductos1, stockProductos1)
    ProductosBDD.agregarProducto(ingresarDatosProductos1.toString())
    val ingresarDatosProductos2 = Productos(nombreProductos2, precioProductos2, stockProductos2)
    ProductosBDD.agregarProducto(ingresarDatosProductos2.toString())
    val ingresarDatosProductos3 = Productos(nombreProductos3, precioProductos3, stockProductos3)
    ProductosBDD.agregarProducto(ingresarDatosProductos3.toString())
}

class ProductosBDD(){
    companion object {
        var productos2: ArrayList<String> = ArrayList()
        val Productos: ArrayList<String> = ArrayList()

        fun agregarProducto(producto: String){
            Productos.add(producto)
        }

        fun removeAll(){
            Productos.clear()
        }

        fun devolverProductos():ArrayList<String> {
            var aux = Productos.size
            var pos = 0
            while (pos < aux ) {
                productos2.add(Productos.get(pos))
                pos++
            }
            return  productos2
        }

        fun comprarProducto(id: Int, cantidad: Int): String {
            if(id == 1 && stockProductos1 >= cantidad){
                stockProductos1 -= cantidad
                ingresarCompra()
                return "Compra realiza con exito"
            }
            else if(id == 2 && stockProductos2 >= cantidad){
                stockProductos2 -= cantidad
                ingresarCompra()
                return "Compra realiza con exito"
            }
            else if(id == 3 && stockProductos3 >= cantidad){
                stockProductos3 -= cantidad
                ingresarCompra()
                return "Compra realiza con exito"
            }
            else{
                ingresarCompra()
                return "...ERROR..."
            }

        }
    }
}