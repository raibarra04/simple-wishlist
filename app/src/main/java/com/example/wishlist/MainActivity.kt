package com.example.wishlist

import android.os.Bundle
import android.util.Half.toFloat
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var listItems: List<ListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

        // Retrieve EditText components of item_name, url, and amount
        val itemName = findViewById<EditText>(R.id.edit_item_name)
        val itemUrl = findViewById<EditText>(R.id.edit_URL)
        val itemAmount = findViewById<EditText>(R.id.edit_amount)

        // Create mutable list to push wishlist items to
        val wishlistItems: MutableList<ListItem> = ArrayList()

        // Set onClick listener for new item submit
        findViewById<Button>(R.id.submit_item).setOnClickListener{
            // Retrieve new wishlist item values
            val itemName = itemName.text.toString()
            val itemUrl = itemUrl.text.toString()
            val itemAmount = itemAmount.text.toString()

            // store in ListItem to append to our mutable list and our listItems List
            val item = ListItem(itemName, itemUrl, itemAmount)
            wishlistItems.add(item)
            listItems = wishlistItems

            // Create adapter passing in the list of items
            val adapter = ListItemAdapter(listItems)
            // Attach the adapter to the RecyclerView to populate items
            wishlistRv.adapter = adapter
            // Set layout manager to position the items
            wishlistRv.layoutManager = LinearLayoutManager(this)

        }
    }
}