package org.almiso.nyt.moview.reviews.businesslayer.activities

import android.os.Bundle
import org.almiso.nyt.moview.reviews.businesslayer.fragments.ReviewsFragment

class MainActivity : AbstractActivity() {
    /*
     * Overrides
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            replaceFragment(ReviewsFragment(), ReviewsFragment.TAG, false)
        }
    }
}
