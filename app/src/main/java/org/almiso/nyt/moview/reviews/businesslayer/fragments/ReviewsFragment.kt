package org.almiso.nyt.moview.reviews.businesslayer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.almiso.nyt.moview.reviews.R


open class ReviewsFragment : AbstractFragment() {
    companion object {
        const val TAG = "ReviewsFragment"
    }


    /*
     * Overrides
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_reviews, container, false)
    }
}
