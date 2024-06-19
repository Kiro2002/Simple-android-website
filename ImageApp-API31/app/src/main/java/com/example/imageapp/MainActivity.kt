package com.example.imageapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenPage2 = findViewById<Button>(R.id.buttonOpenPage2)
        buttonOpenPage2.setOnClickListener {
            val intent = Intent(this, Page2Activity::class.java)
            startActivity(intent)
        }
    }
}
