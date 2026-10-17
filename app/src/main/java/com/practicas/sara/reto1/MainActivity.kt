package com.practicas.sara.reto1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.CheckBox
import android.util.Log
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.ArrayAdapter
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

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

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup_tipo)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_presencial -> Log.d("RADIO", "Seleccionado: Presencial")
                R.id.rb_online     -> Log.d("RADIO", "Seleccionado: Online")
                R.id.rb_mixta      -> Log.d("RADIO", "Seleccionado: Mixta")
            }
        }


        val switchNotificaciones = findViewById<Switch>(R.id.switch_notificaciones)

        switchNotificaciones.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Log.d("SWITCH", "Notificaciones ACTIVADAS")
                // Aquí tu lógica: activar notificaciones, guardar preferencia, etc.
            } else {
                Log.d("SWITCH", "Notificaciones DESACTIVADAS")
                // Aquí tu lógica: desactivar notificaciones, etc.
            }
        }


        val spinnerCurso = findViewById<Spinner>(R.id.spinner_curso)

        // 1. Opciones
        val cursos = listOf("DAM", "DAW")

        // 2. Adaptador
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cursos
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCurso.adapter = adapter

        // 3. Listener para saber cuál se elige
        spinnerCurso.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val cursoSeleccionado = cursos[position]
                Log.d("SPINNER", "Curso seleccionado: $cursoSeleccionado")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se hace nada
            }
        }








    }
}





