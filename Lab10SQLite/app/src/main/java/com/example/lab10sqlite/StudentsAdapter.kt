package com.example.lab10sqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*
import java.text.ParsePosition

class StudentsAdapter (val items: List<Student>, val context: Context) : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvID = view.tv_id
        val tvName = view.tv_name
        val tvage = view.tv_age
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item =
            LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout, parent, false)
        val myHolder = ViewHolder(view_item)
        view_item.setOnClickListener {
            val pos = myHolder.adapterPosition
            val context: Context = parent.context
            val student = items[pos]
            val intent = Intent(context, EditDeleteActivity::class.java)
            intent.putExtra("mId", student.id)
            intent.putExtra("mName", student.name)
            intent.putExtra("mAge", student.age.toString())
            context.startActivities(arrayOf(intent))
        }
        return myHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvID.text = "ID: " + items[position].id
        holder.tvName.text = "ID: " + items[position].name
        holder.tvage.text = "ID: " + items[position].age.toString()
    }
}