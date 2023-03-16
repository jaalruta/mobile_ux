package com.example.alarmaapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RecuperarContrasenaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recuperar_contrasena)

        val buttonVolverClick = findViewById<TextView>(R.id.volver4)
        buttonVolverClick.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }

        val buttonEliminarClick = findViewById<Button>(R.id.btnRecuperarCuenta)
        buttonEliminarClick.setOnClickListener {
            showdialog()

        }
    }

    fun showdialog(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Confirmar")

        val input = EditText(this)
        input.setText("123456")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setMessage("Ingresa el codigo enviado a tu correo")
        builder.setView(input)

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->

            val intent = Intent(this, FanalizaRecuperacionActivity::class.java)
            startActivity(intent)
        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }


}