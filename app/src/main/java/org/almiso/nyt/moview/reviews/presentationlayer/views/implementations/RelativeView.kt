package org.almiso.nyt.moview.reviews.presentationlayer.views.implementations

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import org.almiso.nyt.moview.reviews.presentationlayer.views.IView

open class RelativeView<L> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeLayout(context, attrs, defStyleAttr), IView<L> {

    protected var mListener: L? = null

    override fun setListener(listener: L) {
        mListener = listener
    }

    protected fun getListener() = mListener!!
}
