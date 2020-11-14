package com.kakapo.tugas2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.kakapo.tugas2.R

class UmurView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umur_view)
        calculateAge()
    }

    private fun calculateAge(){
        val input: EditText = findViewById(R.id.getValue)
        val output: TextView = findViewById(R.id.setValue)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val value: Int = 2020 - input.text.toString().toInt()
            output.text  = value.toString()
        }

    }
}