package com.dmn.saludarapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val btnShowText = findViewById<Button>(R.id.btnShowText)
        val btnChange = findViewById<Button>(R.id.btnChange)
        val btnUrl = findViewById<Button>(R.id.btnUrl)

        btnShowText.setOnClickListener { checkValue() }


        btnChange.setOnClickListener {
            val cIntent = Intent(this, ResultActvity::class.java)
            startActivityForResult(cIntent,1)
        }

        btnUrl.setOnClickListener {
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://codelabs.developers.google.com/android-training/")

            startActivity(openUrl)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

        }

    }

    fun checkValue() {
        val etName = findViewById<EditText>(R.id.etName)

        if (etName.text.isNotEmpty()) {
            val intent = Intent(this, ResultActvity::class.java)
            intent.putExtra("INTENT_NAME", etName.text)
            startActivity(intent)

        } else {

            showErrorName()
        }
    }

    fun showErrorName() {
        Toast.makeText(this, "El texto no puede estar  vacio", Toast.LENGTH_SHORT).show()
    }

    fun ShowColor() {
        val bundle = intent.extras
        val layout = findViewById<ConstraintLayout>(R.id.cl1)
        val name = bundle?.get("Color")

        if (name == "red"){
            layout.setBackgroundColor(baseContext.resources.getColor(R.color.red))
        }else if (name == "green"){
            layout.setBackgroundColor(baseContext.resources.getColor(R.color.green))
        }else if (name == "white"){
            layout.setBackgroundColor(baseContext.getColor(R.color.white))

        }
    }
}

//propiedad chain layout