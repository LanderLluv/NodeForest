package com.nodeforest


import android.view.View
import android.widget.TextView

/*
    Clase necesaria para poder utilizar los nodos en las vistas
 */
class ViewHolder internal constructor(view: View?) {
    var textView: TextView

    init {
        textView = view!!.findViewById(R.id.idTvnode)
    }
}