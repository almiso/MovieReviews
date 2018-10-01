package org.almiso.nyt.moview.reviews.presentationlayer.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.almiso.nyt.moview.reviews.R
import org.almiso.nyt.moview.reviews.objects.Review

open class ReviewHolder(itemView: View, listener: IListener?) : AbstractHolder<Review>(itemView), View.OnClickListener {
    interface IListener {
        fun onMoreClicked(item: Review)
    }

    /*
     * Fields
     */
    protected val mListener: IListener? = listener

    protected val mImage: ImageView = itemView.findViewById(R.id.image)
    protected val mTitle: TextView = itemView.findViewById(R.id.title)
    protected val mDate: TextView = itemView.findViewById(R.id.date)
    protected val mSummary: TextView = itemView.findViewById(R.id.summary)
    protected val mMore: View = itemView.findViewById(R.id.more)

    /*
     * Constructor
     */
    init {
        mMore.setOnClickListener(this)
    }


    /*
     * Overrides
     */
    override fun bind(item: Review) {
        super.bind(item)

        mTitle.text = item.displayTitle
        mDate.text = item.date
        mSummary.text = item.summaryShort

        Glide
                .with(itemView.context)
                .load(item.image!!.src!!)
                .into(mImage)
    }

    override fun onClick(view: View?) {
        mListener?.onMoreClicked(item())
    }
}
