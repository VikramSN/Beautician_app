package com.v3cube.beautician.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.v3cube.beautician.ExpandableList.CustomExpandableListAdapter
import com.v3cube.beautician.ExpandableList.ExpandableListDataPump
import com.v3cube.beautician.R
import java.util.ArrayList


class SelectedCategoryList : AppCompatActivity() {

    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<String>? = null
    var expandableListDetail: HashMap<String, List<String>>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selected_cat_list)

        title = "Nails"

        expandableListView = findViewById(R.id.expandableListView)
        expandableListDetail = ExpandableListDataPump.getData()
        expandableListTitle = ArrayList(expandableListDetail!!.keys)
        expandableListAdapter = CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail)
        expandableListView!!.setAdapter(expandableListAdapter)
        expandableListView!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(applicationContext,
                    expandableListTitle!![groupPosition] + " List Expanded.",
                    Toast.LENGTH_SHORT).show()
        }

        expandableListView!!.expandGroup(0)
        expandableListView!!.expandGroup(1)

        expandableListView!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext,
                    expandableListTitle!![groupPosition] + " List Collapsed.",
                    Toast.LENGTH_SHORT).show()
        }

        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                    applicationContext,
                    expandableListTitle!![groupPosition]
                            + " -> "
                            + expandableListDetail!![expandableListTitle!![groupPosition]]!![childPosition], Toast.LENGTH_SHORT
            ).show()
            false
        }
    }

}
