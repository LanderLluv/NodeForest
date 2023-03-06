package com.nodeforest


import android.view.View
import android.widget.TextView

class ViewHolder internal constructor(view: View?) {
    var textView: TextView

    init {
        textView = view!!.findViewById(R.id.idTvnode)
    }
}