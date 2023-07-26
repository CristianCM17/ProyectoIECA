package com.example.proyectoieca

import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
    @SerializedName("token") val token : String,
    @SerializedName("email") val email : String,
    @SerializedName("name") val name : String

)
