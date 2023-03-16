package com.example.alarmaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IniciarSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciarsesion)

        val buttonVolverClick = findViewById<TextView>(R.id.volver)
        buttonVolverClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var buttonCrearCuentaClick = findViewById<TextView>(R.id.crearCuenta)
        buttonCrearCuentaClick.setOnClickListener {
            val intent = Intent(this, CrearCuentaActivity::class.java)
            startActivity(intent)
        }

        var buttonRecuperarCuentaClick = findViewById<TextView>(R.id.recPassword)
        buttonRecuperarCuentaClick.setOnClickListener {
            val intent = Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(intent)
        }

        var buttonIngresarClick = findViewById<TextView>(R.id.btnIngresar)
        buttonIngresarClick.setOnClickListener {
            val intent = Intent(this, PrincipalLoginActivity::class.java)
            startActivity(intent)
        }




    }


}