package com.example.kfc0_.deber1_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_comprar_total.*

class ComprarTotalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_total)

        button_finalizar_compra.setOnClickListener {
            irAMain()
        }
    }

    fun irAMain() {
        //INTENT
        val intentMain = Intent(this, MainActivity::class.java)
        //this.finish()
        this.startActivity(intentMain)
    }

}
