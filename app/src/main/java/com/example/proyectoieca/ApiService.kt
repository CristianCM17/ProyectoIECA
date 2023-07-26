package com.example.proyectoieca

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("update_user")
    fun updateUser(@Body updateUserRequest: UpdateUserRequest): Call<UpdateUserResponse>

    @POST("change_password")
    fun changePassword(@Body changePassRequest: ChangePassRequest): Call<ChangePassResponse>

}