package com.twoninelab.signboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class CustomAdapter(var mainActivity: MainActivity,var colors: Array<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return colors.size;
    }

    override fun getItem(p0: Int): Any {
        return p0;
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view:View = LayoutInflater.from(mainActivity).inflate(R.layout.color_blob,p2,false)
        view?.findViewById<View>(R.id.color_blob).setBackgroundColor(colors[p0].toInt())

        return view
    }


}
