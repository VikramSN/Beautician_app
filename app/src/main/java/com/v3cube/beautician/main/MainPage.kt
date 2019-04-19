package com.v3cube.beautician.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.v3cube.beautician.R
import com.v3cube.beautician.fragment.*
import com.v3cube.beautician.navigation_work.DrawerItemCustomAdapter
import com.v3cube.beautician.pojo.DataModel
import kotlinx.android.synthetic.main.main_header.view.*

class MainPage : AppCompatActivity() {

    private var mNavigationDrawerItemTitles: Array<String>? = null
    private var mDrawerLayout: DrawerLayout? = null
    private var mDrawerList: ListView? = null
    internal var toolbar: Toolbar? = null
    internal var mDrawerTitle: CharSequence? = null
    private var mTitle: CharSequence? = null
    internal var mDrawerToggle: android.support.v7.app.ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        mDrawerTitle = title
        mTitle = mDrawerTitle
        mNavigationDrawerItemTitles = resources.getStringArray(R.array.navigation_drawer_items_array)
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerList = findViewById(R.id.left_drawer)

        val headerView = layoutInflater.inflate(R.layout.main_header, null)
        val prefs = getSharedPreferences("goCosmicUserData", Context.MODE_PRIVATE)
        val uid = prefs.getString("uid", "")
        headerView.navUserName.text = prefs.getString("uname", "")
        headerView.navUserEmail.text = prefs.getString("uemail", "")
        headerView.navUserMobile.text = prefs.getString("umobile", "")
        val ref = prefs.getString("uref", "")

        headerView.navUserSetting.setOnClickListener {
            val userProfileFrag = profileMenu()
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.content_frame, userProfileFrag).commit()
            mDrawerLayout!!.closeDrawer(mDrawerList!!)
        }

//        headerView.navUserImage.setImageResource()
        mDrawerList!!.addHeaderView(headerView)

        val footerView = layoutInflater.inflate(R.layout.main_footer, null)
        mDrawerList!!.addFooterView(footerView)

        setupToolbar()

        val drawerItem = arrayOfNulls<DataModel>(8)

        drawerItem[0] = DataModel(R.drawable.b_profile, "Your Profile")
        drawerItem[1] = DataModel(R.drawable.b_jobs, "Your Jobs")
        drawerItem[2] = DataModel(R.drawable.b_payment, "Payment")
        drawerItem[3] = DataModel(R.drawable.b_wallet, "Wallet")
        drawerItem[4] = DataModel(R.drawable.b_ongoingjobs, "On Going Job")
        drawerItem[5] = DataModel(R.drawable.b_emergency, "Emergency Contact")
        drawerItem[6] = DataModel(R.drawable.b_invite, "Invite")
        drawerItem[7] = DataModel(R.drawable.b_support, "Support")


        this.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        this.supportActionBar!!.setHomeButtonEnabled(true)

        val adapter = DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem)
        mDrawerList!!.adapter = adapter
        mDrawerList!!.onItemClickListener = DrawerItemClickListener()
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerLayout!!.setDrawerListener(mDrawerToggle)
        setupDrawerToggle()

        //============main work=======================================
        val fragment1 = mainFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment1).commit()

    }

    private inner class DrawerItemClickListener : AdapterView.OnItemClickListener {

        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            selectItem(position)
        }

    }

    private fun selectItem(position: Int) {

        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = mainFragment()
            1 -> fragment = profileMenu()
            2 -> fragment = jobMenu()
            3 -> fragment = paymentMenu()
            4 -> fragment = myWalletMenu()
            5 -> fragment = onGoingJobMenu()
            6 -> fragment = emergencyMenu()
            7 -> fragment = inviteMenu()
            8 -> fragment = supportMenu()

            else -> {
            }
        }

        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit()

                mDrawerList!!.setItemChecked(position, true)
                mDrawerList!!.setSelection(position)
                title = mNavigationDrawerItemTitles!![position]
                mDrawerLayout!!.closeDrawer(mDrawerList!!)


        } else {
            Log.e("MainPage", "Error in creating fragment")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (mDrawerToggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun setTitle(title: CharSequence) {
        mTitle = title
        this.supportActionBar!!.title = mTitle
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle!!.syncState()
    }

    internal fun setupToolbar() {
        toolbar = findViewById<View>(R.id.toolbarMain) as Toolbar
        setSupportActionBar(toolbar)
        this.supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    internal fun setupDrawerToggle() {
        mDrawerToggle = android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name)
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle!!.syncState()
    }
}
