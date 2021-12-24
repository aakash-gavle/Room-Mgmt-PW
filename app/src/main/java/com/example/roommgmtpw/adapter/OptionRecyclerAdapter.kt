package com.example.roommgmtpw.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommgmtpw.R
import com.example.roommgmtpw.model.Option

class OptionRecyclerAdapter(optionData: List<Option>):
    RecyclerView.Adapter<OptionRecyclerAdapter.MyViewHolder>() {

    private var options: List<Option> = ArrayList()

    var selected =-1
    var lastSelectedItem=-1

   init {
       this.options=optionData
   }
    var onItemClick: ((String) -> Unit)? = null


   inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val icon =view.findViewById<TextView>(R.id.icon)
        val optionName=view.findViewById<TextView>(R.id.optionName)
       val relLayout=view.findViewById<RelativeLayout>(R.id.relLayout)

       fun defaultBg(){
           relLayout.setBackgroundColor(Color.parseColor("#e6bbad"));
       }
       fun selectedBg(){
           relLayout.setBackgroundColor(Color.parseColor("#da869c"));
       }
       init {

           view.setOnClickListener{
               onItemClick?.invoke(options[adapterPosition].name)
               selected=adapterPosition
               if(lastSelectedItem==-1){
                   lastSelectedItem=selected
           }else {
               notifyItemChanged(lastSelectedItem)
               lastSelectedItem=selected
            }
               notifyItemChanged(selected)
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
        if(position == selected)
            holder.selectedBg()
        else
            holder.defaultBg()
        holder.bindOption(options[position])
    }
}