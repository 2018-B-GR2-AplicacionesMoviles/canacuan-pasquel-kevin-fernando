package com.example.kfc0_.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_navegar.setOnClickListener{

            //Se puede obvear la palabra this
            //this.irAPantallaDeBotones()
            irAPantallaDeBotones()

            /* Log.i("navegacion","HOLA")
            Log.w("navegacion","HOLA")
            Log.d("navegacion","HOLA")
            Log.e("navegacion","HOLA")
            Log.v("navegacion","HOLA") */
        }

        //INTENT DE RESPUESTA
        boton_respuesta.setOnClickListener{
            this.irAPantallaDelIntentRespuesta()
        }
    }

    fun irAPantallaDeBotones() {
        //INTENT -> Moverse de una pantalla a otra
        val intentIrABotones = Intent(this, ButtonActivity::class.java)
        intentIrABotones.putExtra("nombre", "Kevin")
        intentIrABotones.putExtra("apellido", "Canacuan")
        this.startActivity(intentIrABotones)


        //parcelable

        //DEBER para de hoy en 8

    }


    //INTENT DE RESPUESTA
    fun irAPantallaDelIntentRespuesta() {
        //INTENT -> Moverse de una pantalla a otra
        val intentRespuesta = Intent(this, IntentRespuestaActivity::class.java)
        this.startActivity(intentRespuesta)

    }
}

