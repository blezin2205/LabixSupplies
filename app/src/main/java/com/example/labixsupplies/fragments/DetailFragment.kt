package com.example.labixsupplies.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labixsupplies.Detail
import com.example.labixsupplies.DetailAdaptor
import com.example.labixsupplies.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.detail_layout.*

/**
 * A fragment representing a list of Items.
 */
class DetailFragment : Fragment() {

    lateinit var ref: Query

    var details = ArrayList<Detail>()

    var nameOfDevice: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        ref = FirebaseDatabase.getInstance().getReference("Supplies").orderByChild("device").equalTo(nameOfDevice)
//
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if (snapshot.exists()) {
//                    for (item in snapshot.children) {
//                        val detail = item.getValue(Detail::class.java)
//                        details.add(detail!!)
//
//                    }
//
//                    detailView.hasFixedSize()
//                    detailView.layoutManager = LinearLayoutManager(activity)
//                    detailView.adapter = DetailAdaptor(details, view.context)
//                }
//
//            }
//
//        })

    }


}