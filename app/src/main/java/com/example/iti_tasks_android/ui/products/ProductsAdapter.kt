package com.example.iti_tasks_android.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.ui.products.view_model.ProductsState

class ProductsAdapter(private var list: List<ProductsState>) :
    Adapter<ProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            title.text = item.title
            description.text = item.description
            price.text = item.price.toString()
            image.loadImage(item.imageUrl)
        }
        holder.itemView.setOnClickListener { item.onItemClick() }

    }

    fun updateItems(items: List<ProductsState>) {
        list = items
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(view: View) : ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.product_title)
        val description: TextView = view.findViewById(R.id.product_description)
        val price: TextView = view.findViewById(R.id.product_price)
        val image: AppCompatImageView = view.findViewById(R.id.product_image)
    }

}


fun AppCompatImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}
