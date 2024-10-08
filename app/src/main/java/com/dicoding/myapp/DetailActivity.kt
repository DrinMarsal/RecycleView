package com.dicoding.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)

        val shareButton: Button = findViewById(R.id.btn_share)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Check out this movie!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        val filmTitle = intent.getStringExtra("title")
        val filmOverview = intent.getStringExtra("overview")
        val filmImageResId = intent.getIntExtra("image", 0)

        val titleTextView = findViewById<TextView>(R.id.s_description_text_view)
        val overviewTextView = findViewById<TextView>(R.id.f_description_text_view)
        val albumImageView = findViewById<ImageView>(R.id.poster_image_view)

        val backButton = findViewById<ImageButton>(R.id.btn_back)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        titleTextView.text = filmTitle
        overviewTextView.text = filmOverview
        albumImageView.setImageResource(filmImageResId)
    }
}
