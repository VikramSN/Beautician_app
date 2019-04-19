package com.v3cube.beautician.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v3cube.beautician.R
import kotlinx.android.synthetic.main.fragment_invite.view.*

class inviteMenu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_invite,container,false)

        view.inviteBtn.setOnClickListener {
            val intentShare = Intent(Intent.ACTION_SEND)
            intentShare.type = "text/Plain"
            intentShare.putExtra(Intent.EXTRA_SUBJECT, "Subject test")
            intentShare.putExtra(Intent.EXTRA_TEXT, "text body")
            startActivity(Intent.createChooser(intentShare, "Sharing..."))
        }

        return view
    }

}