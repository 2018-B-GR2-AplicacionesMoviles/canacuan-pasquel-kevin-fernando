package com.example.kfc0_.a2018movilesgr2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        boton_ok.setOnClickListener {
            this.devolverRespuesta()
        }
    }

    fun devolverRespuesta() {
        val nombre = editText_nombre.text
        val apellido = editText_apellido.text
        val intentRespuesta = Intent()
        intentRespuesta.putExtra("nombre", nombre)
        intentRespuesta.putExtra("apellido", apellido)

        //metodo para devolver las cosas
        this.setResult(Activity.RESULT_OK, intentRespuesta)

        //finalizar la actividad
        this.finish()
    }


}
