package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.AccessControlProfileId
import kotlin.random.Random
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*

class HeadOrTails : AppCompatActivity() {
    var queue = IntArray(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head_or_tails)

        val backButton = findViewById<Button>(R.id.buttonBack2)


        coinTap()

        backButton.setOnClickListener {
            val backIntent = Intent(applicationContext, MainActivity::class.java)

            startActivity(backIntent)
        }
    }



    private fun coinTap() {

        val coinToss = findViewById<ImageView>(R.id.ivCoin)

        coinToss.setOnClickListener{
            val rand = (1..2).random()

            if(rand == 1){
                flipCoin(R.drawable.head,rand)
            }
            else{
                flipCoin(R.drawable.tail,rand)
            }
        }

    }

    private fun flipCoin(imageId: Int,imageHist: Int){

        val coinToss = findViewById<ImageView>(R.id.ivCoin)
        coinToss.setImageResource(R.drawable.tossup)

        coinToss.animate().apply {
            duration = 1000
            rotationYBy(1800f)
            coinToss.isClickable = false

        }.withEndAction {

            coinToss.setImageResource(imageId)
            coinToss.isClickable = true

            coinHist(imageId,imageHist)

        }.start()
    }

    private fun coinHist(idHist: Int,imageHist: Int){
        val coinH0 = idHist
        var coinH = arrayOf(findViewById(R.id.ivHist1),findViewById<ImageView>(R.id.ivHist1),findViewById<ImageView>(R.id.ivHist2),findViewById<ImageView>(R.id.ivHist3),findViewById<ImageView>(R.id.ivHist4))
        //added extra ivHist1 in index 0 in order to get array to skip index 0

        queue[4] = queue[3]
        queue[3] = queue[2]
        queue[2] = queue[1]
        queue[1] = queue[0]
        queue[0] = imageHist

        for(j in coinH.indices){
            if(j == 0){
            }
            else {
                if (queue[j] == 1) {
                    coinH[j].setImageResource(R.drawable.head)
                } else if (queue[j] == 2) {
                    coinH[j].setImageResource(R.drawable.tail)
                } else {
                    coinH[j].setImageResource(R.drawable.tossup)
                }
            }
        }


    }

}