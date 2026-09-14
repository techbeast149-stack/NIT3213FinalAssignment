package com.example.nit3213finalassignment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        findViewById<TextView>(R.id.detailName).text = intent.getStringExtra("name")
        findViewById<TextView>(R.id.detailArchitect).text = "Architect: ${intent.getStringExtra("architect")}"
        findViewById<TextView>(R.id.detailLocation).text = "Location: ${intent.getStringExtra("location")}"
        findViewById<TextView>(R.id.detailYear).text = "Completed: ${intent.getIntExtra("yearCompleted", 0)}"
        findViewById<TextView>(R.id.detailStyle).text = "Style: ${intent.getStringExtra("style")}"
        findViewById<TextView>(R.id.detailHeight).text = "Height: ${intent.getIntExtra("height", 0)}m"
        findViewById<TextView>(R.id.detailDescription).text = intent.getStringExtra("description")
    }
}