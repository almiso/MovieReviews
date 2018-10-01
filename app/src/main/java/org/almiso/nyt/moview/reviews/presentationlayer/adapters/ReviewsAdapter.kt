package org.almiso.nyt.moview.reviews.presentationlayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.objects.Review
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders.AbstractHolder
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders.ReviewHolder

open class ReviewsAdapter(inflater: LayoutInflater, listener: IListener?) : AbstractAdapter<Review>() {
    interface IListener : ReviewHolder.IListener

    /*
     * Fields
     */
    protected val mInflater: LayoutInflater = inflater
    protected val mListener: IListener? = listener


    /*
     * Overrides
     */
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): AbstractHolder<Review> {
        return ReviewHolder(mInflater.inflate(R.layout.item_review, parent, false), mListener)
    }
}
