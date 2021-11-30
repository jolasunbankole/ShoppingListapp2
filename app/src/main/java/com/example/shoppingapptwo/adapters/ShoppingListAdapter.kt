package com.example.shoppingapptwo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapptwo.R
import com.example.shoppingapptwo.model.ShoppingListData
import com.example.shoppingapptwo.ui.ShoppingListFragment

class ShoppingListAdapter(
    private val dataList: ArrayList<ShoppingListData>,
    private val listener: ShoppingListFragment
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>(){


    inner class ShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val textView: TextView = itemView.findViewById(R.id.shopText)
        val imageView: ImageView = itemView.findViewById(R.id.shoppingcart)
        val cardView: CardView = itemView.findViewById(R.id.cardItem)



        init {
            itemView.setOnClickListener(this)

        }

        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.onClick(position)

        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListAdapter.ShoppingListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ShoppingListViewHolder(itemView)

    }


    override fun onBindViewHolder(holder: ShoppingListAdapter.ShoppingListViewHolder, position: Int) {
        val item = dataList[position]
        holder.cardView
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = item.textView

    }

    override fun getItemCount() = dataList.size





}