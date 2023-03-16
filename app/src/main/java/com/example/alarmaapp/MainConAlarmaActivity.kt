package com.example.alarmaapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainConAlarmaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_con_alarma)

        val buttonClick = findViewById<Button>(R.id.buttonCerrarSesion2)
        buttonClick.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }

        val buttonCrearClick = findViewById<ImageView>(R.id.btnCrearAlarma8)
        buttonCrearClick.setOnClickListener {
            val intent = Intent(this, CrearAlarmaActivity::class.java)
            intent.putExtra("tipo", "Crear")
            intent.putExtra("login", "no")
            startActivity(intent)
        }

        val button3Click = findViewById<Button>(R.id.buttonEditarA2)
        button3Click.setOnClickListener {
            val intent = Intent(this, CrearAlarmaActivity::class.java)
            intent.putExtra("tipo", "editar")
            intent.putExtra("login", "no")
            startActivity(intent)
        }

        val buttonEliminarClick = findViewById<Button>(R.id.buttonEliminarA3)
        buttonEliminarClick.setOnClickListener {
            showdialog()

        }


    }

    fun showdialog(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Confirmar")

        builder.setMessage("¿Esta seguro de eliminar la alarma?")

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }
}