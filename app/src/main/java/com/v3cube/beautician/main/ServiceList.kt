package com.v3cube.beautician.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.v3cube.beautician.R
import com.v3cube.beautician.adapters.ServiceAdapter
import com.v3cube.beautician.pojo.ServiceListPojo
import kotlinx.android.synthetic.main.activity_service_list.*

class ServiceList : AppCompatActivity() {
    var callDatas: ArrayList<ServiceListPojo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)
        serviceRecycle.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        serviceRecycle.adapter = ServiceAdapter(callDatas, this)
        getServiceList()
    }

    private fun getServiceList() {

        for(i in 0..3) {
            callDatas.add(ServiceListPojo(R.drawable.makeup, "Beauty A", "190.10km", "3"))
            callDatas.add(ServiceListPojo(R.drawable.nail, "Beauty B", "101.00km", "2"))
            callDatas.add(ServiceListPojo(R.drawable.waxing, "Beauty C", "59.30km", "4"))
            callDatas.add(ServiceListPojo(R.drawable.hairstyle, "Beauty D", "67.00km", "1"))
            callDatas.add(ServiceListPojo(R.drawable.facial, "Beauty E", "30.00km", "3"))
            callDatas.add(ServiceListPojo(R.drawable.makeup, "Beauty F", "60.00km", "5"))
            callDatas.add(ServiceListPojo(R.drawable.nail, "Beauty G", "100.00km", "5"))
        }

    }
}
