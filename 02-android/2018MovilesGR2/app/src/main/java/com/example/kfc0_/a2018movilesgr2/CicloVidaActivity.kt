package com.example.kfc0_.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVidaActivity : AppCompatActivity() {

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("ciclo-vida", "On Create")
        //revisarSiTieneUnEstadoGuardado(savedInstanceState)
        //onCreate sirve para:
        //Cargar datos -> servicio web -> BDD
        //Cargar datos en la vista
        //Recuperar datos del estado del usuario

        button_contador.setOnClickListener {
            //Aumentar Contador
            this.aumentarContador(1)
        }

    }

    fun revisarSiTieneUnEstadoGuardado(savedInstanceState: Bundle) {
        val contadorGuardado = savedInstanceState.get(SAVE_INSTANCE_STATE_CONTADOR) as Int?
        if(contadorGuardado != null) {
            contador = contadorGuardado
            this.aumentarContador(0)
        }
    }

    fun aumentarContador(suma:Int) {
        contador = contador + suma
        textView_contador.text = contador.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "On Start")

        //onStart sirve para:
        //Presentar los datos al usuario
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "On Resume")

        //onResume sirve para:
        //Ayuda a interactuar con la actividad
        //Ayuda a saber en que otros estados estan las demas actividades
        //Aqui se implementan las mayor parte de funcionalidades de la App
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "On Pause")

        //onPause sirve para:
        //Guardar el estado de la actividad cuando se da clic en "back_button" y "minimizar_aplicacion"
        //Despues de estar en onPause, se ejecuta el onResume y viceversa
        //Cuando la actividad pierde el foco, se puede ir actualizando la interfaz desde otra actividad
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "On Stop")

        //onStop sirve para:
        //Es llamada cuando la actividad ya no es visible al usuario:
        //Actividad destruir activida , empezar nueva actividad o una actividad existente esta entrando en resumen resumen
        //Llama a dos casos:
            //onDestroy -> finaliza la actividad
            //onRestart -> vuelve a la actividad
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "On Restart")

        //onRestart sirve para:
        //Es invocada cuando una actividad esta en el estado de stop y quiere reiniciarse
        //Luego de este callback, se llama al onStart
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "On Destroy")

        //onDestroy sirve para:
        //Es el callback final que la actividad recibe, libera los recursos que utilizaba la actividad
        //Una actividad es destruida cuando es telefono es rotado o cuando se trabaja en multi-ventana
        //Tambien puede ser destruida por el Sistema Operativo
        //Para guardar los datos se puede utlizar:
            //ModeloVista, onSaveInstanceState, almacenamiento local
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.i("ciclo-vida", "On SaveInstanceState")
        
        //guardar datos
        outState?.run { 
            putInt(SAVE_INSTANCE_STATE_CONTADOR, contador)
        }
        
        //llamar despues, no antes
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.revisarSiTieneUnEstadoGuardado(savedInstanceState)
    }
    
    companion object {
        val SAVE_INSTANCE_STATE_CONTADOR = "contador"
    }

}
