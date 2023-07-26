package com.example.proyectoieca

import com.google.gson.annotations.SerializedName

data class ChangePassResponse(

    @SerializedName("name") val name : String,
    @SerializedName("token") val token : String

)
