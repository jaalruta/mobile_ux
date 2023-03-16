package com.example.alarmaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PrincipalLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_login)

        val buttonClick = findViewById<Button>(R.id.btnCerrarSesion)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonCrearClick = findViewById<ImageView>(R.id.btnCrearAlarma2)
        buttonCrearClick.setOnClickListener {
            val intent = Intent(this, CrearAlarmaActivity::class.java)
            intent.putExtra("tipo", "Crear")
            intent.putExtra("login", "si")
            startActivity(intent)
        }

    }
}