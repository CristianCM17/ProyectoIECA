package com.example.proyectoieca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class options : AppCompatActivity() {

    lateinit var btnAcceso : Button
    lateinit var btnModificar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        btnAcceso= findViewById(R.id.btnAcceso)
        btnModificar= findViewById(R.id.btnModificar)

        btnAcceso.setOnClickListener {
            val intent = Intent(this,Contenido::class.java)
            startActivity(intent)
        }

        btnModificar.setOnClickListener {
            val intent = Intent(this,Temas::class.java)
            startActivity(intent)
        }


    }
}