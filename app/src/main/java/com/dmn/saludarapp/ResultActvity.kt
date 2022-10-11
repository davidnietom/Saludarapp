package com.dmn.saludarapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class ResultActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_actvity)
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnRed = findViewById<Button>(R.id.btnRed)
        val btnGreen = findViewById<Button>(R.id.btnGreen)
        val btnWhite = findViewById<Button>(R.id.btnWhite)


        btnBack.setOnClickListener { onBackPressed() }
        btnRed.setOnClickListener { changeColor(btnBack) }
        btnGreen.setOnClickListener { changeColor(btnGreen) }
        btnWhite.setOnClickListener { changeColor(btnWhite) }

        getAndShowName()
    }

    private fun changeColor(button: Button) {
        if (button.id == R.id.btnRed) {
            val red = "red"
            sendMainActivity(red)
        } else if (button.id == R.id.btnGreen) {
            val green = "green"
            sendMainActivity(green)
        } else if (button.id == R.id.btnWhite) {
            val white = "white"
            sendMainActivity(white)
        }
    }

    fun getAndShowName() {
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)

        val bundle = intent.extras
        val name = bundle?.getString("INTENT_NAME")
        if (name.isNullOrBlank()) {

        } else {
            Toast.makeText(this, " $name", Toast.LENGTH_SHORT).show()


        }
    }


    private fun sendMainActivity(color: String) {
        val sIntent = Intent(this,MainActivity::class.java)
        intent.putExtra("COLOR", color)
        startActivity(sIntent)

    }
}


//changeRed.setOnClickListener{(changeRed.setBackgroundColor(Color.RED))}

//button.setBackgroundColor(Color.RED)

//val cambioColor : Button = findViewById(R.id.buttonDePrueba)
//        //Cambia el color del texto luego de hacer click
//        cambioColor.setOnClickListener { cambioColor.setTextColor(Color.parseColor("#9E9E9E")) }

// val rIntent = Intent(this, MainActivity::class.java)
//intent.putExtra("INTENT_NAME",layout)
//startActivity(intent)

//layout.setBackgroundColor(Color.RED)