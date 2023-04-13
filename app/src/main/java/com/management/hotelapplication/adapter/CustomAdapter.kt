package com.management.hotelapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.management.hotelapplication.R
import com.management.hotelapplication.table.MenuModel

class CustomAdapter(private val mylist: List<MenuModel>,val listener: CustomAdapterListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitems_recycler, parent, false)
            return ViewHolder(view)
         }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int)
        {
            val data = mylist[position]
             holder.fdname.text = data.itemName.toString()
             holder.fddes.text = data.description.toString()
             holder.fdprice.text = data.price.toString()
            if (!data.image.isNullOrEmpty()) Glide.with(holder.itemView.context).load(data.image).into(holder.fd_img)

            holder.itemView.setOnClickListener{
                listener.OnItemClick(data)

            }

        }

    // return the number of the items in the list
    override fun getItemCount(): Int
    {
        return mylist.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val fdname:AppCompatTextView = itemView.findViewById(R.id.fd_name)
        val fddes: AppCompatTextView = itemView.findViewById(R.id.fd_descript)
        val fdprice: AppCompatTextView = itemView.findViewById(R.id.fd_price)
        val fd_img: AppCompatImageView = itemView.findViewById(R.id.fd_img)

    }
}

interface CustomAdapterListener{

    fun OnItemClick(data:MenuModel)

}