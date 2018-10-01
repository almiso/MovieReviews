package org.almiso.nyt.moview.reviews.objects

import com.google.gson.annotations.SerializedName

open class ReviewResponse {
    @SerializedName("status") var status: String? = null
    @SerializedName("results") var reviews: List<Review>? = null
}
