package org.almiso.nyt.moview.reviews.businesslayer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.presentationlayer.presenters.ReviewsPresenter
import org.almiso.nyt.moview.reviews.presentationlayer.views.implementations.ReviewView


open class ReviewsFragment : AbstractFragment<ReviewsPresenter>(), ReviewsPresenter.IController {
    companion object {
        const val TAG = "ReviewsFragment"
    }


    /*
     * Overrides
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.view_reviews, container, false)

        val view: ReviewView = layout.findViewById(R.id.review_view)
        val presenter = ReviewsPresenter(view, this)
        setPresenter(presenter)

        return layout
    }
}
