package com.example.nit3213finalassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213finalassignment.ui.DashboardViewModel
import com.example.nit3213finalassignment.ui.EntityAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val keypass = intent.getStringExtra("keypass") ?: return
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = EntityAdapter(onItemClick = { entity ->
            val detailsIntent = Intent(this, DetailsActivity::class.java)
            detailsIntent.putExtra("name", entity.name)
            detailsIntent.putExtra("architect", entity.architect)
            detailsIntent.putExtra("location", entity.location)
            detailsIntent.putExtra("yearCompleted", entity.yearCompleted)
            detailsIntent.putExtra("style", entity.style)
            detailsIntent.putExtra("height", entity.height)
            detailsIntent.putExtra("description", entity.description)
            startActivity(detailsIntent)
        })
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.entitiesState.collect { entities ->
                adapter.updateData(entities)
            }
        }

        viewModel.loadDashboard(keypass)
    }
}