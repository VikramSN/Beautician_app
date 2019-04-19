package com.v3cube.beautician.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v3cube.beautician.R
import com.v3cube.beautician.pojo.ServiceListPojo
import kotlinx.android.synthetic.main.cust_inner.view.*

class ServiceAdapter(private var serviceData: ArrayList<ServiceListPojo>, var context: Context) : RecyclerView.Adapter<ServiceAdapter.ServiceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cust_inner, parent, false)
        return ServiceHolder(view)
    }

    override fun getItemCount(): Int {
        return serviceData.size
    }

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val sData: ServiceListPojo = serviceData[position]
        holder.img.setImageResource(sData.img)
        holder.name.text = sData.name
        holder.dist.text = sData.distance
        holder.rat.rating = sData.rate.toFloat()

        holder.card.setOnClickListener {
//            context.startActivity(Intent(context, SelectedCategoryList::class.java).putExtra("serName", sData.name).putExtra("serDis", sData.distance).putExtra("serRat", sData.rate))
        }
    }

    class ServiceHolder(viewType: View) : RecyclerView.ViewHolder(viewType) {
        var img = viewType.custImg
        var name = viewType.custName
        var dist = viewType.custDistance
        var rat = viewType.custRatting
        var card = viewType.serviceListCardRoot
    }
}

