package org.almiso.nyt.moview.reviews.presentationlayer.views.implementations

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.presentationlayer.views.IReviewsView

open class ReviewView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeView<IReviewsView.IListener>(context, attrs, defStyleAttr), IReviewsView {

    /*
     * Fields
     */
    protected lateinit var mToolbar: Toolbar


    /*
     * Overrides
     */
    override fun onFinishInflate() {
        super.onFinishInflate()

        mToolbar = findViewById(R.id.toolbar)

        mToolbar.title = resources.getString(R.string.title_reviews)
    }
}
