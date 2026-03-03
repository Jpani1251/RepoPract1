package com.example.apppractica1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.app.ActivityOptions
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CORRECCIÓN: El ID en tu XML es "button3"
        val btnIrSistema = findViewById<Button>(R.id.button3)

        // Presiona el botón
        btnIrSistema.setOnClickListener {
            // Desde esta pantalla (this), ve a SistemaSolarActivity
            val intent = Intent(this, SistemaSolarActivity::class.java)
            //Metodo mas moderno
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )

            startActivity(intent, options.toBundle())
        }
    }
}