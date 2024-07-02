package com.open.weatheropennrh

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Ensure you have a layout file named activity_second
        val enteredData = intent.getStringExtra("USERDATA")
        val textview01 = findViewById<TextView>(R.id.textview01)
        val message = "Testing fr $enteredData"
        textview01.text = message


    }
}
