package com.example.kfc0_.deber1_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_registrarse.setOnClickListener {
            irAPantallaDeRegistro()
        }
    }

    fun irAPantallaDeRegistro() {
        //INTENT
        val intentIrRegistro = Intent(this, RegistroUsuario::class.java)
        this.startActivity(intentIrRegistro)
    }
}
