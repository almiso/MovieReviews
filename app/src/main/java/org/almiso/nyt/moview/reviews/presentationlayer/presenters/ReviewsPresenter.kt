package org.almiso.nyt.moview.reviews.presentationlayer.presenters

import org.almiso.nyt.moview.reviews.objects.Review
import org.almiso.nyt.moview.reviews.presentationlayer.views.IReviewsView

open class ReviewsPresenter(view: IReviewsView, controller: IController) : AbstractPresenter(), IReviewsView.IListener {
    interface IController {
        fun loadData()
    }


    /*
     * Fields
     */
    protected val mController: IController = controller
    protected val mView: IReviewsView = view
    protected val mData: MutableList<Review> = ArrayList()


    /*
     * Overrides
     */
    override fun setView() {
        super.setView()

        getView().setListener(this)
    }

    override fun start() {
        super.start()

        if (data().isEmpty()) {
            loadData()
        }
    }


    /*
     * Implemented methods
     */
    override fun onRefreshClicked() {

    }


    /*
     * Protected methods
     */
    protected fun loadData() {
        getView().showProgress(true)
        getController().loadData()
    }

    protected open fun data() = mData

    protected open fun getController() = mController

    protected open fun getView() = mView
}
