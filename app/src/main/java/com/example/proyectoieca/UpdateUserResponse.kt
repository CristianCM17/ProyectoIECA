package com.example.proyectoieca

import com.google.gson.annotations.SerializedName

data class UpdateUserResponse(
    @SerializedName("name") val name : String,
    @SerializedName("token") val token : String


)
