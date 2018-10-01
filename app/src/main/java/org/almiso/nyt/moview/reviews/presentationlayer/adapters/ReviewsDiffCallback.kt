package org.almiso.nyt.moview.reviews.presentationlayer.adapters

import android.support.v7.util.DiffUtil
import android.text.TextUtils
import org.almiso.nyt.moview.reviews.objects.Review

open class ReviewsDiffCallback(oldList: List<Review>, newList: List<Review>) : DiffUtil.Callback() {
    /*
     * Fields
     */
    protected val mOldList: List<Review> = oldList
    protected val mNewList: List<Review> = newList


    /*
     * Overrides
     */
    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldReview = mOldList[oldItemPosition]
        val newReview = mNewList[oldItemPosition]

        return TextUtils.equals(oldReview.headline, newReview.headline)
    }

    // TODO maybe better to use hash
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldReview = mOldList[oldItemPosition]
        val newReview = mNewList[oldItemPosition]

        return TextUtils.equals(oldReview.displayTitle, newReview.displayTitle)
                && TextUtils.equals(oldReview.summaryShort, newReview.summaryShort)
    }
}
