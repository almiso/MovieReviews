package org.almiso.nyt.moview.reviews.businesslayer.managers

import android.util.Log

open class ReviewsManager {
    companion object {
        const val TAG = "ReviewsManager"
    }


    /*
     * Public methods
     */
    fun loadReviews() {
        Log.d(TAG, "Start loading")
    }

}
