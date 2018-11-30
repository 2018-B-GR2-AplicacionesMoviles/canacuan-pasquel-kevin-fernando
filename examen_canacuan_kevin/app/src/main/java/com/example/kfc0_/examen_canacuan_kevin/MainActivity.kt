package com.example.kfc0_.examen_canacuan_kevin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ingresar.setOnClickListener {
            this.irAPantallaIngresar()
        }

        button_listar.setOnClickListener {
            this.irAPantallaListar()
        }


    }

    fun irAPantallaIngresar () {
        val intentActividadIngresar = Intent(this, IngresarActivity::class.java)
        this.startActivity(intentActividadIngresar)
    }

    fun irAPantallaListar () {
        val intentActividadListar = Intent(this, ListarActivity::class.java)
        this.startActivity(intentActividadListar)
    }
}
