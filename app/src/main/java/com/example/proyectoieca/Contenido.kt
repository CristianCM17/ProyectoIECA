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
                PptItem("Fundamentos de Java", "https://drive.google.com/file/d/1wzLTXz_nb_ktsKRf2fvczM00FgkYjU7B/view?usp=sharing"),
                PptItem("Fundamentos de Android", "https://drive.google.com/file/d/1Lc78I1IJ6B3QrVDWQ2gp05aeMAj1F3tY/view?usp=sharing"),
                PptItem("Activities de Android", "https://drive.google.com/file/d/1OkKGnGoanu2LfuA2to48V8AeXkXTp4OY/view?usp=sharing"),
                PptItem("Componentes graficos de Andoroid", "https://drive.google.com/file/d/1DSe75V9MfmgrWUs6J7kcffhDRrdHFycf/view?usp=sharing"),
                PptItem("Fragments", "https://drive.google.com/file/d/1NdpHRyO8_IDf2yrnzp9pl3h0ykj9uup-/view?usp=sharing"),
                PptItem("Servicios Web", "https://drive.google.com/file/d/1N5z70ZMSoR32thdJrvuTQXU7kRGEjZ5M/view?usp=sharing"),
                PptItem("Fire Base", "https://drive.google.com/file/d/1XHmgjroOjJYPcdesZmqzer4_KEjpE1-Z/view?usp=sharing"),
                PptItem("Utilidades Avanzadas", "https://drive.google.com/file/d/1h88dQ_59AKP-_1RM4_S-kU23vKlB8-u4/view?usp=sharing")

        )

        gridAdapter = GridAdapter(this, pptItems)
        gridView.adapter = gridAdapter
    }


    }
