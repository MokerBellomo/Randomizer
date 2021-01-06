package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rngButton = findViewById<Button>(R.id.buttonRng)
        val hotButton = findViewById<Button>(R.id.buttonHot)

        rngButton.setOnClickListener {
            val rngIntent = Intent(applicationContext, RandomNumberGenerator::class.java)

            startActivity(rngIntent)
        }

        hotButton.setOnClickListener {
            val hotIntent = Intent(applicationContext, HeadOrTails::class.java)

            startActivity(hotIntent)
        }
    }
}