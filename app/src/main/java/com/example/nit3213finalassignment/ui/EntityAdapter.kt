package com.example.nit3213finalassignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213finalassignment.R
import com.example.nit3213finalassignment.data.Entity

class EntityViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
    private val textName: TextView = view.findViewById(R.id.textName)
    private val textArchitect: TextView = view.findViewById(R.id.textArchitect)
    private val textLocation: TextView = view.findViewById(R.id.textLocation)
    private val textYear: TextView = view.findViewById(R.id.textYear)

    fun bind(entity: Entity, onClick: (Entity) -> Unit) {
        textName.text = entity.name
        textArchitect.text = entity.architect
        textLocation.text = entity.location
        textYear.text = entity.yearCompleted.toString()
        itemView.setOnClickListener { onClick(entity) }
    }
}

class EntityAdapter(
    private var dataList: List<Entity> = listOf(),
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(dataList[position], onItemClick)
    }

    override fun getItemCount() = dataList.size

    fun updateData(newDataList: List<Entity>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}