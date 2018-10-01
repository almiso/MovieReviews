package org.almiso.nyt.moview.reviews.presentationlayer.views.implementations

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.util.Log
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.objects.Review
import org.almiso.nyt.moview.reviews.presentationlayer.views.IReviewsView

open class ReviewView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeView<IReviewsView.IListener>(context, attrs, defStyleAttr), IReviewsView {

    /*
     * Fields
     */
    protected lateinit var mToolbar: Toolbar
    protected lateinit var mRefreshLayout: SwipeRefreshLayout


    /*
     * Overrides
     */
    override fun onFinishInflate() {
        super.onFinishInflate()

        mToolbar = findViewById(R.id.toolbar)
        mRefreshLayout = findViewById(R.id.swipe_refresh)

        mToolbar.title = resources.getString(R.string.title_reviews)
        mRefreshLayout.setOnRefreshListener {
            getListener().onRefreshClicked()
        }
    }


    /*
     * Implemented methods
     */
    override fun showProgress(isVisible: Boolean) {
        mRefreshLayout.isRefreshing = isVisible
    }

    override fun showError() {

    }

    override fun setData(items: List<Review>) {
        for (item in items) {
            Log.d("ReviewView", "item: " + item.displayTitle)
        }
    }
}
