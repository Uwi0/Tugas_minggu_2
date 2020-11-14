package com.kakapo.tugas2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kakapo.tugas2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createLogin()
    }

    private fun createLogin(){
        val loginButton: Button = findViewById(R.id.login_button)

        loginButton.setOnClickListener{
            val username: EditText = findViewById(R.id.user_name)
            val password: EditText = findViewById(R.id.password)

            if(username.text.toString() == "admin" && password.text.toString() == "admin"){
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}