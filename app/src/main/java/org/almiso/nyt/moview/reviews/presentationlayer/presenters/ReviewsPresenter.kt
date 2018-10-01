package org.almiso.nyt.moview.reviews.presentationlayer.presenters

import org.almiso.nyt.moview.reviews.presentationlayer.views.IReviewsView

open class ReviewsPresenter(view: IReviewsView, controller: IController) : AbstractPresenter(), IReviewsView.IListener {
    interface IController {
    }


    /*
     * Fields
     */
    protected val mController: IController = controller
    protected val mView: IReviewsView = view


    /*
     * Overrides
     */
    override fun setView() {
        super.setView()

        getView().setListener(this)
    }


    /*
     * Protected methods
     */
    protected open fun getController() = mController

    protected open fun getView() = mView
}
