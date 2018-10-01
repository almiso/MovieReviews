package org.almiso.nyt.moview.reviews.presentationlayer.views

import org.almiso.nyt.moview.reviews.objects.Review

interface IReviewsView : IView<IReviewsView.IListener> {
    interface IListener {
        fun onRefreshClicked()
    }

    fun showProgress(isVisible: Boolean)
    fun showError()
    fun setData(items: List<Review>)
}
