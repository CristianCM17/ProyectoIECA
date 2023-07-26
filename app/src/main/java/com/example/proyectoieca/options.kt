package com.example.proyectoieca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class options : AppCompatActivity() {

    lateinit var btnAcceso : Button
    lateinit var btnModificar: Button
    lateinit var btnReglamento: Button
    lateinit var btnExamen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        btnAcceso= findViewById(R.id.btnAcceso)
        btnModificar= findViewById(R.id.btnModificar)
        btnExamen= findViewById(R.id.btnExamen)
        btnReglamento= findViewById(R.id.btnReglamento)

        btnAcceso.setOnClickListener {
            val intent = Intent(this,Contenido::class.java)
            startActivity(intent)
        }

        btnModificar.setOnClickListener {
            val intent = Intent(this,Temas::class.java)
            startActivity(intent)
        }

        btnModificar.setOnClickListener {
            val intent = Intent(this,Reglamento::class.java)
            startActivity(intent)
        }

        btnModificar.setOnClickListener {
            val intent = Intent("https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=24&resourceId=217")
            startActivity(intent)
        }

    }
}