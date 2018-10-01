package org.almiso.nyt.moview.reviews.presentationlayer.adapters

import android.support.v7.widget.RecyclerView
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders.AbstractHolder

abstract class AbstractAdapter<T> : RecyclerView.Adapter<AbstractHolder<T>>() {
    protected val mItems: MutableList<T> = ArrayList()

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: AbstractHolder<T>, position: Int) {
        holder.bind(mItems[position])
    }

    fun data() = mItems

    fun reset(items: List<T>) {
        mItems.clear()
        mItems.addAll(items)
    }
}
