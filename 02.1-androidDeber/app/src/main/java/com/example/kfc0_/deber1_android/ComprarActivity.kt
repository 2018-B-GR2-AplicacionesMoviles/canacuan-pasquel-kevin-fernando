package com.example.kfc0_.deber1_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_comprar.*

class ComprarActivity : AppCompatActivity() {

    val precio_sandias:Int = 1
    val precio_peras:Int = 2
    val precio_manzanas:Int = 3
    var total:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar)

        button_comprar.setOnClickListener {
            irACalcularTotal()
        }
    }

    fun irACalcularTotal() {
        //INTENT
        val intentTotal = Intent(this, ComprarTotalActivity::class.java)

        if(checkBox_1.isChecked) total += (precio_sandias * Integer.parseInt(editText_1_1.text.toString()))
        if(checkBox_2.isSelected) total += (precio_peras * Integer.parseInt(editText_2_1.text.toString()))
        if(checkBox_3.isSelected) total += (precio_manzanas * Integer.parseInt(editText_3_1.text.toString()))
        else total = 0

        Log.i("total-enviar", "TOTAL: ${total}")

        //intentTotal.putExtra("total", total)
        this.startActivity(intentTotal)
    }

}
