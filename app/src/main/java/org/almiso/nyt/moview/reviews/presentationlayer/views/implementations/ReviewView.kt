package org.almiso.nyt.moview.reviews.presentationlayer.views.implementations

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.objects.Review
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.ReviewsAdapter
import org.almiso.nyt.moview.reviews.presentationlayer.adapters.ReviewsDiffCallback
import org.almiso.nyt.moview.reviews.presentationlayer.views.IReviewsView

open class ReviewView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeView<IReviewsView.IListener>(context, attrs, defStyleAttr), IReviewsView {

    /*
     * Fields
     */
    protected lateinit var mToolbar: Toolbar
    protected lateinit var mRefreshLayout: SwipeRefreshLayout
    protected lateinit var mRecycler: RecyclerView
    protected lateinit var mError: TextView

    protected lateinit var mAdapter: ReviewsAdapter


    /*
     * Overrides
     */
    override fun onFinishInflate() {
        super.onFinishInflate()

        mToolbar = findViewById(R.id.toolbar)
        mRefreshLayout = findViewById(R.id.swipe_refresh)
        mRecycler = findViewById(R.id.recycler)
        mError = findViewById(R.id.error)

        mToolbar.title = resources.getString(R.string.title_reviews)
        mRefreshLayout.setOnRefreshListener {
            getListener().onRefreshClicked()
        }
        mRecycler.layoutManager = LinearLayoutManager(context)
    }

    override fun setListener(listener: IReviewsView.IListener) {
        super.setListener(listener)

        mAdapter = ReviewsAdapter(LayoutInflater.from(context), getListener())
        mRecycler.adapter = mAdapter
    }

    /*
     * Implemented methods
     */
    override fun showProgress(isVisible: Boolean) {
        mRefreshLayout.isRefreshing = isVisible
        setViewVisibility(mError, false)
    }

    override fun showError() {
        mRefreshLayout.isRefreshing = false
        setViewVisibility(mRecycler, false)
        setViewVisibility(mError, true)
    }

    override fun setData(items: List<Review>) {
        setViewVisibility(mRecycler, true)
        mRefreshLayout.isRefreshing = false
        setViewVisibility(mError, false)

        val reviewsDiffCallback = ReviewsDiffCallback(mAdapter.data(), items)
        val reviewsDiffResult = DiffUtil.calculateDiff(reviewsDiffCallback)

        mAdapter.reset(items)
        reviewsDiffResult.dispatchUpdatesTo(mAdapter)
    }


    /*
     * Protected methods
     */
    protected fun setViewVisibility(view: View, isVisible: Boolean) {
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}
