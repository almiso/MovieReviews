package org.almiso.nyt.moview.reviews.businesslayer.network

import org.almiso.nyt.moview.reviews.objects.ReviewResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

interface ReviewsService {
    companion object {
        const val BASE_URL = "http://api.nytimes.com/svc/movies/v2/"
    }

    // TODO replace with your own api key
    @Headers("api-key: API_KEY")
    @GET("reviews/all.json")
    fun loadReviews(): Observable<ReviewResponse>
}
