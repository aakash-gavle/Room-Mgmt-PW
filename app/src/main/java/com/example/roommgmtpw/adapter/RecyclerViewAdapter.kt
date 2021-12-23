package com.example.roommgmtpw.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roommgmtpw.R
import com.example.roommgmtpw.model.Facility

class RecyclerViewAdapter:
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var items: List<Facility> = ArrayList()

    var onItemClick: ((Facility) -> Unit)? = null

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        private val options:RecyclerView = view.findViewById(R.id.optionRecyclerView)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])

            }
        }

        fun bind(result: Facility) {
            name.text = result.name
            val optionRecyclerAdapter = OptionRecyclerAdapter(result.options)
            options.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL,false)
            options.adapter = optionRecyclerAdapter

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_data, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setData(list: List<Facility>){
        items=list
        notifyDataSetChanged()
    }
}