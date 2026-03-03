package com.example.apppractica1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.ActivityOptions

class SistemaSolarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. IMPORTANTE: Llamar a enableEdgeToEdge ANTES del setContentView
        enableEdgeToEdge()
        setContentView(R.layout.activity_sistema_solar)

        // 2. Solución al error de pantalla blanca:
        // Usamos el ID 'main' que ya incluiste en tu XML.
        val mainLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)

        if (mainLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // 3. Configuración de botones con IDs correctos del XML
        val btnPlanetas = findViewById<Button>(R.id.mover_planetas)
        val btnRegreso = findViewById<Button>(R.id.Regreso)

        btnPlanetas?.setOnClickListener {
            val intent = Intent(this, PlanetasActivity::class.java)

            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )

            startActivity(intent, options.toBundle())
        }

        btnRegreso?.setOnClickListener {
            finish()
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}