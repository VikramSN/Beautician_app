package com.v3cube.beautician.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v3cube.beautician.R
import com.v3cube.beautician.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_your_job.view.*

class jobMenu: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_your_job,container,false)
        val adapter = ViewPagerAdapter(childFragmentManager)
        view.viewpagerforjob.adapter = adapter
        view.tabs.setupWithViewPager(view.viewpagerforjob)
        view.tabs.getTabAt(0)!!.setIcon(R.drawable.privacy)
        view.tabs.getTabAt(1)!!.setIcon(R.drawable.faq)
        return view
    }

}