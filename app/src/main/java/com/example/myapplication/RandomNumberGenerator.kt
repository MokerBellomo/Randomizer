package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class RandomNumberGenerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number_generator)

        val rollMax = findViewById<EditText>(R.id.inputRollMax)
        val rollButton = findViewById<Button>(R.id.buttonRollMax)
        val result = findViewById<TextView>(R.id.outputResult)
        val backButton = findViewById<Button>(R.id.buttonBack)

        rollButton.setOnClickListener {
            val rand = (1..rollMax.text.toString().toInt()).random()
            result.text = rand.toString()
        }

        backButton.setOnClickListener {
            val backIntent = Intent(applicationContext, MainActivity::class.java)

            startActivity(backIntent)
        }
    }
}