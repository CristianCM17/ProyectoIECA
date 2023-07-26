package com.example.proyectoieca

import com.google.gson.annotations.SerializedName

data class ChangePassRequest(
    @SerializedName("token") val token : String,
    @SerializedName("password") val password : String
)
