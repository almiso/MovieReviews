package org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class AbstractHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var mItem: T? = null

    open fun bind(item: T) {
        mItem = item
    }

    protected fun item() = mItem!!
}
