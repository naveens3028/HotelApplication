package com.management.hotelapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.management.hotelapplication.model.MenuModel

class CustomAdapter(private val mylist:ArrayList<MenuModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>()
    {

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder

        {

            val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitems_recycler, parent, false)

            return ViewHolder(view)
         }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int)
        {

             holder.fdname.text = mylist.get(position).itemName.toString()
             holder.fddes.text = mylist.get(position).description.toString()
             holder.fdprice.text = mylist.get(position).price.toString()
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

    }
    }

