package com.example.labixsupplies

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.device_supply.*
import kotlinx.android.synthetic.main.devices.*

class DeviceSupplyActivity: AppCompatActivity() {

    lateinit var ref: Query

     var details = ArrayList<Detail>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.device_supply)

        val nameOfDevice = intent.getStringExtra("name")

        ref = FirebaseDatabase.getInstance().getReference("Supplies").orderByChild("device").equalTo(nameOfDevice)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val detail = item.getValue(Detail::class.java)
                        details.add(detail!!)

                    }

                   detailView.hasFixedSize()
                    detailView.layoutManager = LinearLayoutManager(this@DeviceSupplyActivity)
                    detailView.adapter = DetailAdaptor(details, this@DeviceSupplyActivity)
                }

            }

        })



    }
}