package com.example.labixsupplies

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.labixsupplies.fragments.DetailFragment
import com.example.labixsupplies.fragments.ListFragment
import javax.security.auth.callback.Callback

interface OnRowClickListener {
    fun onRowClick(device: String)
}

class MyAdapter(listArray: ArrayList<Device>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context






    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.deviceTextView)
        val myFragment = DetailFragment()
        val listener: OnRowClickListener by ListFragment()

        fun bind(device: Device, context: Context) {
            name.text = device.name
            itemView.setOnClickListener() {

                listener.onRowClick(device.name)
               Log.i("1", device.name)


            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.devices_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val device = listArrayR.get(position)
        holder.bind(device, contextR)

    }
}