package com.example.roommgmtpw.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roommgmtpw.R
import com.example.roommgmtpw.model.Option

class OptionRecyclerAdapter(optionData: List<Option>):
    RecyclerView.Adapter<OptionRecyclerAdapter.MyViewHolder>() {

    private var options: List<Option> = ArrayList()

   init {
       this.options=optionData
   }
    var onItemClick: ((String) -> Unit)? = null

   inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val icon =view.findViewById<TextView>(R.id.icon)
        val optionName=view.findViewById<TextView>(R.id.optionName)
       val relLayout=view.findViewById<RelativeLayout>(R.id.relLayout)

       init {
           view.setOnClickListener{
               onItemClick?.invoke(options[adapterPosition].name)
               Toast.makeText(view.context,"Item Selected",Toast.LENGTH_SHORT).show()
               relLayout.setBackgroundColor(Color.parseColor("#dac486"));

           }
       }

        fun bindOption(value: Option){
            icon.text=value.icon
            optionName.text=value.name

            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.option_data, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindOption(options[position])
    }
}