package com.kakapo.tugas2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kakapo.tugas2.R

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        createButtonKalkulatorBmi()
        createButtonKalkulatorUmur()
        createButtonListView()
        createButtonRecyclerView()
    }

    private fun createButtonKalkulatorBmi(){
        val buttonBmi: Button = findViewById(R.id.kalkulator_bmi)
        buttonBmi.setOnClickListener {
            val intent = Intent(this, BmiView::class.java)
            startActivity(intent)
        }
    }

    private fun createButtonKalkulatorUmur(){
        val buttonUmur: Button = findViewById(R.id.kalkulator_umur)
        buttonUmur.setOnClickListener {
            val intent = Intent(this, UmurView::class.java)
            startActivity(intent)
        }
    }

    private fun createButtonListView(){
        val buttonList: Button = findViewById(R.id.list_view)
        buttonList.setOnClickListener {
            val intent = Intent(this, ListView::class.java)
            startActivity(intent)
        }
    }

    private fun createButtonRecyclerView(){
        val buttonRecyclerView: Button = findViewById(R.id.list_recycler_view)
        buttonRecyclerView.setOnClickListener{
            val intent = Intent(this, ListRecyclerView::class.java)
            startActivity(intent)
        }
    }
}