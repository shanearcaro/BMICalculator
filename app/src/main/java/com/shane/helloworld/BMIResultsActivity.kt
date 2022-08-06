package com.shane.helloworld

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresults)

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }
    }

    override fun onStart() {
        super.onStart()

        // Intents are like a map of key value pairs between activities
        // This is just fetching the result intent from the previous activity
        val result = intent.extras?.getString("result") ?: "Invalid"
        val resultTextView = findViewById<TextView>(R.id.resultIntent)
        resultTextView.text = result

        val number = result.substringAfter(" ").toDouble()

        CLog("Number: $number")

        val backgroundColor: Int = when {
            number < 18.5 -> Color.YELLOW
            number < 25.0 -> Color.GREEN
            number < 30.0 -> Color.rgb(229, 142, 13)
            else -> Color.RED
        }
        window.decorView.setBackgroundColor(backgroundColor)
    }
}
