package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetials : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detials)

        val iHeading = intent.getStringExtra("heading")
        val iText = intent.getStringExtra("context")
        val iImage = intent.getIntExtra("image",R.drawable.img1)

        // form this activities xml
        var image = findViewById<ImageView>(R.id.newsDetailsImage)
        var heading = findViewById<TextView>(R.id.newsHeading)
        var context=findViewById<TextView>(R.id.newsDetailsText)

        image.setImageResource(iImage)
        heading.text=iHeading
        context.text=iText



    }
}