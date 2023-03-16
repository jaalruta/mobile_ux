package com.example.alarmaapp

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class CrearAlarmaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_alarma)

        val tipo = intent.getStringExtra("tipo")
        val login = intent.getStringExtra("login")
        var textoFinal = "Alarma creada";
        if (tipo=="editar")
        {
            val btnCrearAlarma = findViewById<Button>(R.id.btnCrearAlarma3);
            btnCrearAlarma.setText("Editar Alarma") ;

            val txtAccion = findViewById<TextView>(R.id.txtAccion);
            txtAccion.setText("Editar Alarma") ;

            textoFinal = "Alarma editada";
        }

        val btnHoraClick = findViewById<EditText>(R.id.txtHora)
        btnHoraClick.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus)
            {
                btnHoraClick.clearFocus();
                val cal = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    btnHoraClick.setText(SimpleDateFormat("HH:mm").format(cal.time)) ;

                }
                TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            }
        }
        val buttonVolverClick = findViewById<TextView>(R.id.volver10)
        buttonVolverClick.setOnClickListener {
            finish()
        }

        val btnCrearAlarma = findViewById<Button>(R.id.btnCrearAlarma3);
        btnCrearAlarma.setOnClickListener {

            Toast.makeText(this,textoFinal, Toast.LENGTH_LONG).show()
            if(login=="si")
            {
                val intent = Intent(this, PrincipalLoginConAlarmaActivity::class.java)
                startActivity(intent)
            }
            else
            {
                val intent = Intent(this, MainConAlarmaActivity::class.java)
                startActivity(intent)
            }

        }

        val btnCrearClasficacion = findViewById<ImageView>(R.id.btnCrearClasficacion);
        btnCrearClasficacion.setOnClickListener {
            showdialogClasificacion();
        }

        val btnCrearInteraccion = findViewById<ImageView>(R.id.btnCrearInteraccion);
        btnCrearInteraccion.setOnClickListener {
            showdialogInteraccion();
        }

        val btnCrearUbicacion = findViewById<ImageView>(R.id.btnCrearUbicacion);
        btnCrearUbicacion.setOnClickListener {
            showdialogMapa();
        }
    }

    fun showdialogClasificacion(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Confirmar")

        val input = EditText(this)
        input.setText("Medicamentos")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setMessage("Ingresa el nombre de la clasificación")
        builder.setView(input)

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this,"Clasificación creada", Toast.LENGTH_LONG).show()
            dialog.cancel()
        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

    fun showdialogInteraccion(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("IOT")

        val btn = Button(this)
        btn.setText("Cafetera");


        builder.setMessage("Selecciona el dispositivo")
        builder.setView(btn)

        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        val dialog = builder.show()

        btn.setOnClickListener {
            dialog.cancel();
            showdialogInteraccionFinal();
        }
    }

    fun showdialogInteraccionFinal(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("IOT")

        val btn = Button(this)
        btn.setText("Prender");


        builder.setMessage("Cafetera - Selecciona el una acción")
        builder.setView(btn)

        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        val dialog = builder.show()

        btn.setOnClickListener {
            Toast.makeText(this,"Interacción creada", Toast.LENGTH_LONG).show()
            dialog.cancel();
        }
    }
    fun showdialogMapa(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Ubicación")

        var inflater = layoutInflater.inflate(R.layout.map_image_dialog,null);

        builder.setMessage("Selecciona Una Ubicación")
        builder.setView(inflater)

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this,"Ubicación creada", Toast.LENGTH_LONG).show()
            dialog.cancel()
        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        val dialog = builder.show()
    }
}