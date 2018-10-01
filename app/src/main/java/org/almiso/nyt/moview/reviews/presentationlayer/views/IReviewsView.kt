package org.almiso.nyt.moview.reviews.presentationlayer.views

interface IReviewsView : IView<IReviewsView.IListener> {
    interface IListener {
        fun onRefreshClicked()
    }

    fun showProgress(isVisible: Boolean)

}
