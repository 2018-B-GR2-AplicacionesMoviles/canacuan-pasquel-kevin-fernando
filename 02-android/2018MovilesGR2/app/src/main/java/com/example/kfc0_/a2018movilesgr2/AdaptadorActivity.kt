package com.example.kfc0_.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import kotlinx.android.synthetic.main.activity_adaptador.*
import java.util.*

class AdaptadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptador)

        val arregloUsuarios = ArrayList<Usuario>()

        val usuarioUno = Usuario(
                "Fernando",
                29,
                Date(1994,11,5),
                15.20
        )
        val usuarioDos = Usuario(
                "Nicolas",
                23,
                Date(1991,12,9),
                22.00
        )

        arregloUsuarios.add(usuarioUno)
        arregloUsuarios.add(usuarioDos)

        //ADAPTADOR
        val adaptadorUsuarios = ArrayAdapter<Usuario>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arregloUsuarios
        )
        spinner_usuarios.adapter = adaptadorUsuarios

        spinner_usuarios
                .onItemSelectedListener =
                object :AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        Log.i("adaptador", "${parent}")
                        Log.i("adaptador", "${view}")
                        Log.i("adaptador", "${position}")
                        Log.i("adaptador", "${id}")

                        val usuario = arregloUsuarios[position]
                        Log.i("adaptador", "${usuario.nombre}")
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Log.i("adaptador", "${parent}")
                    }
                }

        //TRABAJO EN CLASE
        val adaptadorListViewUsuarios = ArrayAdapter<Usuario>(this, android.R.layout.simple_expandable_list_item_1, arregloUsuarios)
        listView_nombres.adapter = adaptadorListViewUsuarios

        listView_nombres
                .onItemClickListener =
                object : AdapterView.OnItemClickListener {
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        Log.i("adaptador_deber", "${parent}")
                        Log.i("adaptador_deber", "${view}")
                        Log.i("adaptador_deber", "${position}")
                        Log.i("adaptador_deber", "${id}")

                        Log

                        val usuario = arregloUsuarios[position]
                        Log.i("adaptador_deber", "${usuario.nombre}")
                        textView_trabajoEnClase.setText("${usuario.nombre}")

                        //edad, nombre, sueldo

                        textView_linearLayout1_vertical.setText("${usuario.edad}")
                        button_linearLayout_vertical.setText("${usuario.nombre}")
                        textView_linearLayout2_vertical.setText("${usuario.sueldo}")

                        textView_linearLayout1_horizontal.setText("${usuario.edad}")
                        button_linearLayout_horizontal.setText("${usuario.nombre}")
                        textView_linearLayout2_horizontal.setText("${usuario.sueldo}")

                    }

                }

    }
}
