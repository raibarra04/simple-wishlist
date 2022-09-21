package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListItemAdapter(private val listItems: List<ListItem>) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView
        val urlTextView: TextView
        val amountTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.itemNameTv)
            urlTextView = itemView.findViewById(R.id.urlTv)
            amountTextView = itemView.findViewById(R.id.amountTv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val listItem = listItems.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = listItem.name
        holder.urlTextView.text = listItem.URL
        holder.amountTextView.text = listItem.amount.toString()
    }

    override fun getItemCount(): Int {
        return listItems.count()
    }
}