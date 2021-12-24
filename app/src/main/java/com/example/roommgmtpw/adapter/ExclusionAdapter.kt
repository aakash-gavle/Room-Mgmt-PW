package com.example.roommgmtpw.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommgmtpw.R
import com.example.roommgmtpw.model.Exclusion

class ExclusionAdapter:
    RecyclerView.Adapter<ExclusionAdapter.MyViewHolder>() {

    private var items: List<Exclusion> = ArrayList()

    var onItemClick: ((Exclusion) -> Unit)? = null

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val facilityId: TextView = view.findViewById(R.id.facilityId)
        val optionId: TextView = view.findViewById(R.id.optionId)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }

        fun bind(result: Exclusion) {
            facilityId.text = result.facilityId
            optionId.text = result.optionsId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exclusion_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setExclusionData(list: List<Exclusion>){
        items=list
        notifyDataSetChanged()
    }

}