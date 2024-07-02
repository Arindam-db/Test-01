package com.open.weatheropennrh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.INVISIBLE
import androidx.constraintlayout.widget.ConstraintSet.VISIBLE
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nxtbtn = findViewById<Button>(R.id.buttonnxt)
        val heading = findViewById<TextView>(R.id.head01)
        val locationTextView = findViewById<EditText>(R.id.enterloc)
        val buttonSubmit = findViewById<Button>(R.id.locationset)
        var enteredData = ""
        buttonSubmit.setOnClickListener{
            enteredData = locationTextView.text.toString()
            if (enteredData == "")
            {
                nxtbtn.visibility = View.INVISIBLE
                Toast.makeText(this@MainActivity,"Please enter your location", Toast.LENGTH_SHORT).show()
            }
            else {
                nxtbtn.visibility = View.VISIBLE
                val output01 = "You live in $enteredData"
                heading.text = output01
                locationTextView.text.clear()

                // Hide the keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(locationTextView.windowToken, 0)
            }
        }
             nxtbtn.setOnClickListener{
                 val intent = Intent(this,SecondActivity::class.java)

                 intent.putExtra("USERDATA",enteredData)

                 startActivity(intent)
             }
    }
}