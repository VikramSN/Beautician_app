package com.v3cube.beautician.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v3cube.beautician.R
import com.v3cube.beautician.main.SelectedCategoryList
import com.v3cube.beautician.main.services.ServiceOffer
import kotlinx.android.synthetic.main.fragment_main.view.*

class mainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)

        view.mainNails.setOnClickListener {
            startActivity(Intent(activity, SelectedCategoryList::class.java))
        }

        view.mainMakeup.setOnClickListener {
            startActivity(Intent(activity, ServiceOffer::class.java))
        }

        view.mainWaxing.setOnClickListener {
            startActivity(Intent(activity, SelectedCategoryList::class.java))
        }

        view.mainHair.setOnClickListener {
            startActivity(Intent(activity, SelectedCategoryList::class.java))
        }

        view.mainFacial.setOnClickListener {
            startActivity(Intent(activity, SelectedCategoryList::class.java))
        }

        view.mainBrownBar.setOnClickListener {
            startActivity(Intent(activity, SelectedCategoryList::class.java))
        }

        return view
    }


}