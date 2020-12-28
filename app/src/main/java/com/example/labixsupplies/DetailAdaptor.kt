package com.example.labixsupplies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DetailAdaptor(listArray: ArrayList<Detail>, context: Context): RecyclerView.Adapter<DetailAdaptor.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.detail_description)
        val lastAddUser = view.findViewById<TextView>(R.id.last_add)
        val lastDeleteUser = view.findViewById<TextView>(R.id.last_delete)
        val count = view.findViewById<TextView>(R.id.detail_count)


        fun bind(detail: Detail, context: Context) {
            name.text = detail.description
            lastAddUser.text = detail.lastAddUser
            lastDeleteUser.text = detail.lastDeleteUser
            count.text = detail.count.toString()

            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed: ${name.text}", Toast.LENGTH_SHORT).show()
//                val i = Intent(context, DeviceSupplyActivity::class.java).apply {
//                    putExtra("name", name.text.toString())
//                }
//                context.startActivity(i)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.detail_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detail = listArrayR.get(position)
        holder.bind(detail, contextR)

    }


}