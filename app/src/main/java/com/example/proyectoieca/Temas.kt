package com.example.proyectoieca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.SharedPreferences



class Temas : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password : EditText
    lateinit var updateUserButton: Button
    lateinit var changePasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temas)

        name = findViewById(R.id.nameEditText)
        email = findViewById(R.id.emailEditText)
        password= findViewById(R.id.passwordEditText)
         updateUserButton = findViewById(R.id.updateUserButton)
        changePasswordButton= findViewById(R.id.changePasswordButton)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Recupera el token guardado en SharedPreferences
        val apiToken = sharedPreferences.getString("api_token", null)?: ""
        Toast.makeText(applicationContext,apiToken,Toast.LENGTH_LONG).show()


        updateUserButton.setOnClickListener {
            val apiService= ApiClient.getClient()


            // Si los campos no están vacíos, realizar la solicitud
            if (name.text.toString().isNotBlank() && email.text.toString().isNotBlank()) {
                val body :UpdateUserRequest = UpdateUserRequest(apiToken, email.text.toString(),name.text.toString())

                // Realizar la solicitud para /update_user
                val call= apiService.updateUser(body)
                call.enqueue(object: Callback<UpdateUserResponse>{
                    override fun onResponse(
                        call: Call<UpdateUserResponse>,
                        response: Response<UpdateUserResponse>
                    ) {
                        if (response.isSuccessful){
                          //  val loginResponse= response.body()

                            Toast.makeText(applicationContext,"Datos cambiados",Toast.LENGTH_LONG).show()

                        }else
                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<UpdateUserResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error de red",Toast.LENGTH_LONG).show()
                    }
                })

            } else {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }


        changePasswordButton.setOnClickListener{
            val apiService= ApiClient.getClient()


            // Si los campos no están vacíos, realizar la solicitud
            if (password.text.toString().isNotBlank()) {
                val body :ChangePassRequest = ChangePassRequest(apiToken, password.text.toString())

                // Realizar la solicitud para /update_user
                val call= apiService.changePassword(body)
                call.enqueue(object: Callback<ChangePassResponse>{
                    override fun onResponse(
                        call: Call<ChangePassResponse>,
                        response: Response<ChangePassResponse>
                    ) {
                        if (response.isSuccessful){
                            //val loginResponse= response.body()

                            Toast.makeText(applicationContext,"Contrasenia cambiada",Toast.LENGTH_LONG).show()

                        }else
                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<ChangePassResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error de red",Toast.LENGTH_LONG).show()
                    }
                })

            } else {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}