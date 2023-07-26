package com.example.proyectoieca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView


class Contenido : AppCompatActivity() {

     lateinit var gridView: GridView
     lateinit var gridAdapter: GridAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenido)

                gridView = findViewById(R.id.gridView)

            // Crear una lista de elementos PptItem con los títulos y URLs
            val pptItems = listOf(
                PptItem("Fundamentos de Java", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Fundamentos de Android", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Activities de Android", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Componentes graficos de Andoroid", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Fragments", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Servicios Web", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Fire Base", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12"),
                PptItem("Utilidades Avanzadas", "https://ieca.conectatalentomx.com/app/virtual-classroom/3?moduleId=17&resourceId=12")

        )

        gridAdapter = GridAdapter(this, pptItems)
        gridView.adapter = gridAdapter
    }


    }
