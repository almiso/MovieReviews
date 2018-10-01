package org.almiso.nyt.moview.reviews.businesslayer.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.businesslayer.managers.ReviewsManager
import org.almiso.nyt.moview.reviews.businesslayer.managers.events.ReviewsEvent
import org.almiso.nyt.moview.reviews.presentationlayer.presenters.ReviewsPresenter
import org.almiso.nyt.moview.reviews.presentationlayer.views.implementations.ReviewView
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject


open class ReviewsFragment : AbstractFragment<ReviewsPresenter>(), ReviewsPresenter.IController {
    companion object {
        const val TAG = "ReviewsFragment"
    }


    /*
     * Fields
     */
    @Inject protected lateinit var reviewsManager: ReviewsManager


    /*
     * Overrides
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.view_reviews, container, false)

        val view: ReviewView = layout.findViewById(R.id.review_view)
        val presenter = ReviewsPresenter(view, this)
        setPresenter(presenter)

        return layout
    }


    /*
     * Implemented methods
     */
    override fun loadData() {
        reviewsManager.loadReviews()
    }


    /*
     * Events
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoadGistComplete(event: ReviewsEvent) {
        if (event.isSuccess()) {
            presenter().loadDataComplete(event.data()!!)
        } else {
            presenter().loadDataFail()
        }
    }
}
