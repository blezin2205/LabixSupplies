package com.example.labixsupplies.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labixsupplies.Device
import com.example.labixsupplies.MyAdapter
import com.example.labixsupplies.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.devices.*

class ListFragment : Fragment(), MyAdapter.OnRowClickListener {

    lateinit var ref: DatabaseReference
    var devicesList = ArrayList<Device>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ref = FirebaseDatabase.getInstance().getReference("Devices")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                var devices = ArrayList<Device>()

                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        var device = Device(item.key!!)
                        devices.add(device)
                    }
                    devicesList = devices
                    devicesView.hasFixedSize()
                    devicesView.layoutManager = LinearLayoutManager(activity)
                    devicesView.adapter = MyAdapter(devicesList, view.context)
                }
            }

        })
    }

    override fun onRowClick(device: String) {
        Log.i("2", device)
    }

}