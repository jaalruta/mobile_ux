package com.example.alarmaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CrearCuentaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_cuenta)

        val buttonVolverClick = findViewById<TextView>(R.id.volver3)
        buttonVolverClick.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }

        val buttonCrearCuentaClick = findViewById<Button>(R.id.btnCrearCuenta)
        buttonCrearCuentaClick.setOnClickListener {

            Toast.makeText(this,"Cuenta Creada",Toast.LENGTH_LONG).show()

            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }




    }


}