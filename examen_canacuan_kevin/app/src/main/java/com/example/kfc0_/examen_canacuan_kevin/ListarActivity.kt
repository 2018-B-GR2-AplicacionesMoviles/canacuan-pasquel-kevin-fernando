package com.example.kfc0_.examen_canacuan_kevin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_listar.*
import java.util.ArrayList

class ListarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)


        val arregloProductos = intent.getParcelableArrayExtra("arregloProductos")

        //val adaptadorListViewUProductos =
         //  ArrayAdapter<Productos>(this, android.R.layout.simple_expandable_list_item_1, arregloProductos)
        //lista.adapter = adaptadorListViewUProductos

        arregloProductos


    }
}
