package com.example.kfc0_.deber1_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_registro_cliente2.*

class RegistroCliente2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_cliente2)

        button_direccion.setOnClickListener {
            irAPantallaDeDireccionCliente()
        }

        button_okCliente.setOnClickListener {
            irAPantallaPrincipal()
        }
    }

    fun irAPantallaDeDireccionCliente() {
        //INTENT
        val intentIrDireccionCliente = Intent(this, DireccionCLienteMapsActivity::class.java)
        this.startActivity(intentIrDireccionCliente)
    }

    fun irAPantallaPrincipal() {
        //INTENT
        val intentMain = Intent(this, MainActivity::class.java)
        Log.i("edad", "EDAD: ${editText_edad.text}")
        Log.i("fecha_nacimiento", "FECHA NACIMIENTO: ${editText2_fecha_nacimineto.text}")
        Log.i("direccion", "DIRECCION: ${editText3_direccion!!.text}")
        this.startActivity(intentMain)
    }

}
