package com.example.imageapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageResource = intent.getIntExtra("imageResource", 0)
        imageView.setImageResource(imageResource)

        imageView.setOnClickListener {
            finish()
        }


        imageView.setOnClickListener {
            toggleFullScreen()
        }
    }

    private fun toggleFullScreen() {
        val decorView = window.decorView
        if (decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {

            supportActionBar?.hide()
            decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                    )
        } else {

            supportActionBar?.show()
            decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    )
        }
    }
}
