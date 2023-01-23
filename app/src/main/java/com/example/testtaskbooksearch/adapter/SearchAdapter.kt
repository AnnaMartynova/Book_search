package com.example.testtaskbooksearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskbooksearch.R
import com.example.testtaskbooksearch.model_data.BookInfo
import com.example.testtaskbooksearch.model_data.SearchListResponse
import com.example.testtaskbooksearch.model_data.VolumeInfo

class SearchAdapter(var arrayList: ArrayList<VolumeInfo>) :
    RecyclerView.Adapter<SearchAdapter.ElementHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ElementHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ElementHolder, position: Int) {
        val searchListItem = arrayList[position]
        holder.bind(searchListItem)

//        Picasso.get().load(arrayList[position].volumeInfo.imageLinks).into(holder.imageView)

    }

    class ElementHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: VolumeInfo) {
            with(itemView) {


//                val imageView: ImageView = itemView.findViewById(R.id.imageView)

                findViewById<TextView>(R.id.titleTextView).text = data.volumeInfo.title
//                findViewById<TextView>(R.id.authorTextView).text = data.volumeInfo.authors.toString()
//                findViewById<TextView>(R.id.categoriesTextView).text = data.volumeInfo.categories.toString()
                findViewById<TextView>(R.id.publishedDataTextView).text = data.volumeInfo.publishedDate


                findViewById<CardView>(R.id.cardView).elevation = 0f

                if (((adapterPosition) % 2) == 0) {
                    setBackgroundResource(R.drawable.corners_dark)
                } else {
                    setBackgroundResource(R.color.colorWait)
                }


            }

        }
    }
}