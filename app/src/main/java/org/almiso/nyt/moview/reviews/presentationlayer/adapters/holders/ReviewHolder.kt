package org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders

import android.view.View
import org.almiso.nyt.moview.reviews.objects.Review

open class ReviewHolder(itemView: View, listener: IListener?) : AbstractHolder<Review>(itemView), View.OnClickListener {
    interface IListener {
        fun onMoreClicked(item: Review)
    }

    /*
     * Fields
     */
    protected val mListener: IListener? = listener


    /*
     * Constructor
     */
    init {
        itemView.setOnClickListener(this)
    }


    /*
     * Overrides
     */
    override fun bind(item: Review) {
        super.bind(item)

    }

    override fun onClick(view: View?) {
        mListener?.onMoreClicked(item())
    }
}
