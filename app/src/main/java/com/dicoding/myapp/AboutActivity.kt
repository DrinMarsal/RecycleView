package com.dicoding.myapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.about_page)
            val backButton: ImageButton = findViewById(R.id.button_about2)!!
            backButton.setOnClickListener {
                finish()
            }
        } catch (e: Exception) {
            e.printStackTrace()

            Log.e("AboutActivity", "Error: ${e.message}")
        }
    }
}