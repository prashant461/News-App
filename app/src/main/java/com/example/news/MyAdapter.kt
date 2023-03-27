package com.example.news

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(val myArrayList: ArrayList<News>, val context:Activity):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener:onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        myListener=listener
    }

    // to create new view instance
    // when layout manager fails to find suitable view for item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemdata=myArrayList[position]
        holder.hTitle.text=itemdata.newsHeading
        holder.hImage.setImageResource(itemdata.newsImage)
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    // it holds the view so view are not created everytime and memory can be saved
    class MyViewHolder(itemView:View, listener:onItemClickListener):RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage=itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

}