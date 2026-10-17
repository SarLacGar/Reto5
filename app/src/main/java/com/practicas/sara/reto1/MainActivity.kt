package com.practicas.sara.reto1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.CheckBox
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los CheckBox
        val check1 = findViewById<CheckBox>(R.id.CheckBOx_Android)
        val check2 = findViewById<CheckBox>(R.id.CheckBOx_React)
        val check3 = findViewById<CheckBox>(R.id.CheckBOx_Flutter)

        // Listener para el primer CheckBox
        check1.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Opción 1 marcada: $isChecked")
            // Aquí puedes ejecutar la lógica que necesites
        }

        // Listener para el segundo CheckBox
        check2.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Opción 2 marcada: $isChecked")
        }

        // Listener para el tercer CheckBox
        check3.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Opción 3 marcada: $isChecked")
        }
    }
}





