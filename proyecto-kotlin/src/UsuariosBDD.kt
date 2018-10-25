import java.util.ArrayList

class UsuariosBDD(){
    companion object {
        val Usuarios: ArrayList<String> = ArrayList()
        fun agregarUsuario(usuario: String){
            Usuarios.add(usuario)
        }
        fun devolverUsuario():ArrayList<String> {
            val aux = Usuarios.size
            var pos: Int = 0
            var users: ArrayList<String> = ArrayList()
            while (pos < aux) {
                users.add(Usuarios.get(pos))
                pos++
            }
            return  users
        }
    }
}