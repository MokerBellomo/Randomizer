package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class HeadOrTails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head_or_tails)

        val backButton = findViewById<Button>(R.id.buttonBack2)
        val flipButton = findViewById<Button>(R.id.buttonFlip)
        val result = findViewById<TextView>(R.id.outputResult2)

        backButton.setOnClickListener {
            val backIntent = Intent(applicationContext, MainActivity::class.java)

            startActivity(backIntent)
        }

        flipButton.setOnClickListener {
            val rand = Random.nextInt(2)

            if (rand == 0) {
                result.text = "HEAD"
            } else {
                result.text = "TAIL"
            }
        }
    }
}