package com.example.kfc0_.examen_canacuan_kevin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.ArrayList

class GuardarDatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar_datos)

        val nombre = intent.get("producto")
        val precio = intent.getParcelableExtra<Productos>("precio")
        val cantidad = intent.getParcelableExtra<Productos>("cantidad")
        val tipo = intent.getParcelableExtra<Productos>("tipo")
        Log.i("msg2", nombre)

        val arregloProductos = ArrayList<Productos>()
        val producto = Productos(
            nombre.nombre,
            precio.precio,
            cantidad.cantidad,
            tipo.tipo
        )

        arregloProductos.add(producto)

        Log.i("msg2", arregloProductos.toString())

        val intentListarActivity = Intent(this, ListarActivity::class.java)
        intentListarActivity.putParcelableArrayListExtra("arregloProductos", arregloProductos)
        this.startActivity(intentListarActivity)


    }

}