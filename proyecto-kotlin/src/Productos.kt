class Productos(var nombreProductos: String, var precioProductos: Double, var stockProducto: Int){
    override fun toString(): String {
        return "\nProducto\nNombre: ${this.nombreProductos} " +
                "\nPrecio: ${this.precioProductos.toString()} " +
                "\nStock: ${this.stockProducto.toString()}"
    }
}