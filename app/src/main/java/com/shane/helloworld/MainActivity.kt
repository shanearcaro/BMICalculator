package com.shane.helloworld

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * XML is extensible markup language, its pretty much HTML but designed a little different.
 * XML is responsible for the overall layout of each activity, this makes sense.
 * 
 * The code is the CSS, get the XML (HTML) to look and act a certain way.
 */

// Activity is basically a screen. MainActivity is the Main screen of the application
class MainActivity : AppCompatActivity() {
    // onCreate() is called just before the app starts.
    // If you want certain code to run when an activity first shows up, put it here
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // setContentView() prepares and displays the UI to the user.
        // R. refers to the res folder, layout.activity_main is referencing the XML file
        setContentView(R.layout.activity_main)

        // Change background color of app
        window.decorView.setBackgroundColor(Color.WHITE)

        // Set the results text invisible before it is used
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        resultsTextView.visibility = View.INVISIBLE

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val weightEditText = findViewById<EditText>(R.id.weightEditText)
            val heightEditText = findViewById<EditText>(R.id.heightEditText)

            val weight: Double = weightEditText.text?.toString()?.toDouble() ?: 0.0
            val height: Double = heightEditText.text?.toString()?.toDouble() ?: 0.0

            val bmi = weight / (height * height)

            CLog("Weight: $weight")
            CLog("Height: $height")

            /**
             * We are creating an intent. An intent lets us move from one Activity instance to
             * another. In our case, we specify that we move from the current activity (this) to
             * to BMIResultsActivity. The BMIResultsActivity::class.java retrieves the full name
             * of the BMIResultsActivity instance. .java is at the end because all the Kotlin
             * code is turning into Java byte code.
             *
             * Because we need to pass the BMI result to the new Activity, we use putExtra() which
             * allows us to store valuest hat we want to pass over. In our case, we specify the
             * 'result' key which stores the formatted BMI result.
             *
             * startActivity() just switches to the new activity.
             */

            val resultIntent = Intent(this, BMIResultsActivity::class.java)
            resultIntent.putExtra("result", "BMI: " + String.format("%.2f", bmi))
            startActivity(resultIntent)
        }
    }
}