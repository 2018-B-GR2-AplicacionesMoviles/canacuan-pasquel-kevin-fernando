package com.example.kfc0_.examen_canacuan_kevin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)

        button_guardar.setOnClickListener {
            this.guardarDatos()
        }

        button_cancelar.setOnClickListener {
            this.irAPantallaPrincipal()
        }
    }

    fun guardarDatos() {
        val nombre = textView_nombre.text
        val precio = textView_precio.text
        val cantidad = textView_cantidad.text
        val tipo = textView_tipo.text

        val intentGuardar = Intent()

    }

    fun irAPantallaPrincipal() {
        val intentPantallaPrincipal = Intent(this, MainActivity::class.java)
        this.startActivity(intentPantallaPrincipal)
    }
}
