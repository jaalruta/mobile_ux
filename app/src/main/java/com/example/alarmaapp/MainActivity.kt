package com.example.alarmaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }

        val buttonCrearClick = findViewById<ImageView>(R.id.btnCrearAlarma)
        buttonCrearClick.setOnClickListener {
            val intent = Intent(this, CrearAlarmaActivity::class.java)
            intent.putExtra("tipo", "Crear")
            intent.putExtra("login", "no")
            startActivity(intent)
        }



    }


}