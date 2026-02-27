package com.example.apppractica1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlazamos el botón de la interfaz
        val btnIrSistema = findViewById<Button>(R.id.btn_ir_sistema)

        // Presiona el boton
        btnIrSistema.setOnClickListener {

            //Desde esta pantalla (this), ve a SistemaSolarActivity
            val intent = Intent(this, SistemaSolarActivity::class.java)

            //Arrancamos la nueva Activity
            startActivity(intent)
        }
    }
}