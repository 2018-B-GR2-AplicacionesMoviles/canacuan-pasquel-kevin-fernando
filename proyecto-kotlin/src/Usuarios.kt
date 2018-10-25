class Usuarios(var nombreUsuarios: String, var direccionUsuarios: String, var telefonoUsuarios: String){
    override fun toString(): String {
        return "\nUsuario\nNombre: ${this.nombreUsuarios}" +
            "\nDireccion: ${this.direccionUsuarios}" +
            "\nTelefono: ${this.telefonoUsuarios}"
    }
}
