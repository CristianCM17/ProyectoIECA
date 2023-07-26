package com.example.proyectoieca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.SharedPreferences
import android.content.Context


class MainActivity : AppCompatActivity() {
    lateinit var btnlogin: Button
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnlogin= findViewById(R.id.btnlogin)
        email= findViewById(R.id.username)
        password= findViewById(R.id.password)



        btnlogin.setOnClickListener{
            val apiService= ApiClient.getClient()

            val body : LoginRequest = LoginRequest(email.text.toString(),password.text.toString())

            val call = apiService.login(body)
            call.enqueue(object: Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful){
                        val loginResponse= response.body()
                        val token = loginResponse?.token
                        saveToken(token)
                        Toast.makeText(applicationContext,"Bienvenido "+loginResponse?.name,Toast.LENGTH_LONG).show()
                        intent()
                    }else
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    //manejar error de red
                    Toast.makeText(applicationContext,"Error de red",Toast.LENGTH_LONG).show()
                }
            })
        }

    }

    fun intent(){
        val intent = Intent(this,options::class.java)
        startActivity(intent)
    }

    fun saveToken(token : String?){
        // Guarda el token en SharedPreferences

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("api_token", token)
        editor.apply()


    }
}