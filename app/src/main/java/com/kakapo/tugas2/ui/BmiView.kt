package com.kakapo.tugas2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.kakapo.tugas2.R

class BmiView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_view)
        choseGender()
    }

    private fun calculateBmi() : Double{
        val inputBerat: EditText = findViewById(R.id.input_berat)
        val inputTinggi: EditText = findViewById(R.id.input_tinggi)
        val berat: Double = inputBerat.text.toString().toDouble()
        val tinggi: Double = inputTinggi.text.toString().toDouble() / 100
        return  berat / (tinggi * tinggi)
    }

    private fun choseGender(){
        val radioGroup: RadioGroup = findViewById(R.id.opsi)
        var pilihan = ""
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.Laki_Laki){
                pilihan = "laki laki"
                outputBmi("laki laki")
            }else if(checkedId == R.id.Perempuan){
               outputBmi("perempuan")
            }
        }

    }

    private fun outputBmi(jenisKelamin: String){
        val button: Button = findViewById(R.id.proses)
        button.setOnClickListener {
            
            val hasil = calculateBmi()

            if (jenisKelamin == "perempuan"){
                when {
                    hasil.toInt() < 17 -> {
                        Toast.makeText(this,"kurus", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() in 17..22 -> {
                        Toast.makeText(this,"ideal", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() in 23..26 -> {
                        Toast.makeText(this,"gemuk", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() > 27 -> {
                        Toast.makeText(this,"obesitas", Toast.LENGTH_SHORT).show()
                    }
                }
            }else if(jenisKelamin == "laki laki") {
                when {
                    hasil.toInt() < 18 -> {
                        Toast.makeText(this, "kurus", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() in 18..25 -> {
                        Toast.makeText(this, "ideal", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() in 25..27 -> {
                        Toast.makeText(this, "gemuk", Toast.LENGTH_SHORT).show()
                    }
                    hasil.toInt() > 27 -> {
                        Toast.makeText(this, "obesitas", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}