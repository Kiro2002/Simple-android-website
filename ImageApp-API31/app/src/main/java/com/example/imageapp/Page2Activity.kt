package com.example.imageapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class Page2Activity : AppCompatActivity() {

    private val images = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )
    private var currentImageIndex = 0

    private lateinit var imageView: ImageView
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        imageView = findViewById(R.id.imageView)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)
        buttonBack = findViewById(R.id.buttonBack)

        updateImage()

        buttonPrevious.setOnClickListener {
            showPreviousImage()
        }

        buttonNext.setOnClickListener {
            showNextImage()
        }

        imageView.setOnClickListener {
            enlargeImage()
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--
            updateImage()
        }
    }

    private fun showNextImage() {
        if (currentImageIndex < images.size - 1) {
            currentImageIndex++
            updateImage()
        }
    }

    private fun updateImage() {
        imageView.setImageResource(images[currentImageIndex])
    }

    private fun enlargeImage() {
        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra("imageResource", images[currentImageIndex])
        startActivity(intent)
    }
}
