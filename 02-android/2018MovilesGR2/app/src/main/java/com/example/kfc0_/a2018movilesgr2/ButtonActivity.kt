package com.example.kfc0_.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    var nombre:String = ""
    var apellido:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        this.capturarDatosDelIntent()
        act_but_nombre_apellido
                .text = "${nombre} ${apellido}"

        but_but_intent_implicito        //ID BOTON
                .setOnClickListener{
                    enviarIntentCorreo()
                }
    }

    fun capturarDatosDelIntent() {
        //se puede usar o no el this.
        this.nombre = intent.getStringExtra("nombre")
        apellido = intent.getStringExtra("apellido")
    }

    fun enviarIntentCorreo() {
        val correo = but_input_correo.text
        val subject = but_input_subject.text
        val texto = but_input_texto.text

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "texto/html"  //Se define el tipo exacto del intent

        //Definicion de Parametros
        intent.putExtra(Intent.EXTRA_EMAIL, arrayListOf(correo, "10@hotmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, texto)

        startActivity(intent)

    }
}
