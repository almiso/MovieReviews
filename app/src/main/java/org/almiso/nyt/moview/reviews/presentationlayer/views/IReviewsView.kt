package org.almiso.nyt.moview.reviews.presentationlayer.views

import org.almiso.nyt.moview.reviews.objects.Review
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.ReviewsAdapter

interface IReviewsView : IView<IReviewsView.IListener> {
    interface IListener : ReviewsAdapter.IListener {
        fun onRefreshClicked()
    }

    fun showProgress(isVisible: Boolean)
    fun showError()
    fun setData(items: List<Review>)
}
