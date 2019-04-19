package com.v3cube.beautician.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v3cube.beautician.R
import kotlinx.android.synthetic.main.fragment_profile.view.*

class profileMenu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile,container,false)

        val prefs = activity!!.getSharedPreferences("goCosmicUserData", Context.MODE_PRIVATE)
        val uid = prefs.getString("uid", "")
        view.uFn.text = prefs.getString("uname", "")
        view.uEml.text = prefs.getString("uemail", "")
        view.uCont.text = prefs.getString("umobile", "")
        val ref = prefs.getString("uref", "")
        return view
    }

}