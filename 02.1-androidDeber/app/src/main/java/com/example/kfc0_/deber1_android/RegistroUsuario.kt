package com.example.kfc0_.deber1_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_registro_usuario.*

class RegistroUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        button_siguienteRegCliente.setOnClickListener {
            irAPantallaDeRegistro2()
        }
    }

    fun irAPantallaDeRegistro2() {
        //INTENT
        val intentIrRegistro2 = Intent(this, RegistroCliente2Activity::class.java)
        Log.i("nombre", "NOMBRE: ${editText_nombre.text}")
        Log.i("password", "PASSWORD: ${editText2_password.text}")
        Log.i("email", "E-MAIL: ${editText3_email.text}")
        Log.i("telefono", "TELEFONO: ${editText4_telefono.text}")
        this.startActivity(intentIrRegistro2)
    }
}

