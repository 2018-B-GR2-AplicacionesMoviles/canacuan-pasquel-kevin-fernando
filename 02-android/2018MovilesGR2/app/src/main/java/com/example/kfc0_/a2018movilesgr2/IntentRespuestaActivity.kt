package com.example.kfc0_.a2018movilesgr2

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado_propio.*
import java.lang.Exception

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        //obtener datos de un intent de otra app hacia nuestra app
        val texto:String? = intent.getStringExtra(Intent.EXTRA_TEXT)
        Log.i("intent-texto", "Texto: ${texto}")

        //INTENT DE RESPUESTA -> ENVIAR
        boton_enviar_intent.setOnClickListener{
            this.enviarIntentRespuesta()
        }

        boton_nombre_apellido.setOnClickListener{
            this.enviarIntentRespuestaPropio()
        }
    }

    fun enviarIntentRespuestaPropio() {
        val intentRespuestaNombreApellido = Intent(this, ResultadoPropioActivity::class.java)    //Intent para seleccionar un contacto
        this.startActivityForResult(intentRespuestaNombreApellido, requestCodeNombreApellido)
    }

    fun enviarIntentRespuesta() {
        val intentRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)    //Intent para seleccionar un contacto
        this.startActivityForResult(intentRespuesta, IntentRespuestaActivity.requestCodeContactos)
    }

    //Cuando se manda un intent, dentro del intent se ejecuta la siguiente funcion
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Log.i("intent-respuesta","${requestCode}")
        //Log.i("intent-respuesta","${requestCode}")
        //Log.i("intent-respuesta","${data}")

        when (requestCode) {
            requestCodeContactos -> {

                //usando el resultCode
                when (resultCode) {
                    RESULT_OK -> {
                        Log.i("contactos", "respuesta: ${data}")

                        //para tomar el nombre y numero telefonico del contacto
                        var cursor: Cursor? = null
                        try {
                            var numeroTelefono: String? = null
                            var nombre: String? = null
                            var tieneNumeroTelefono: String? = null
                            val uri = data?.data

                            cursor = contentResolver.query(uri, null, null, null, null) //-> realizar consultas mediante la uri
                            cursor!!.moveToFirst()      //!! -> algo puede ser nulo
                            val indiceTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            val indiceNombre = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                            val indiceTieneNumeroTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER)

                            //obtener los datos dependiendo de los indices
                            numeroTelefono = cursor!!.getString(indiceTelefono)
                            nombre = cursor!!.getString(indiceNombre)
                            tieneNumeroTelefono = cursor!!.getString(indiceTieneNumeroTelefono)

                            Log.i("contacto", "TELEFONO: ${numeroTelefono}  - NOMBRE: ${nombre}")
                            Log.i("contacto", "TIENE NUMERO DE TELEFONO ? ${tieneNumeroTelefono}")
                        }
                        catch (e:Exception) {
                            Log.i("contacto", "ERROR !!")
                        }
                    }
                    RESULT_CANCELED -> {
                        Log.i("contactos", "NO SE SELECCIONO NINGUN CONTACTO")
                    }
                }
                //Log.i("contactos", "respuesta: ${data}")
            }

            requestCodeNombreApellido -> {
                Log.i("intent-nombre-apellido", "NOMBRE: ${data!!.getStringExtra("nombre")}")
                Log.i("intent-nombre-apellido", "NOMBRE: ${data!!.getStringExtra("apellido")}")
            }

            else -> {
                Log.i("contactos", "indefinido")
            }
        }
    }

    //companion object -> unica instancia del intent
    companion object {
        val requestCodeContactos = 101
        val requestCodeNombreApellido = 102
    }

}
