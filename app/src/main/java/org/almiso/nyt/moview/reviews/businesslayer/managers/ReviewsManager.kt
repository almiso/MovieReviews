package org.almiso.nyt.moview.reviews.businesslayer.managers

import android.util.Log
import org.almiso.nyt.moview.reviews.businesslayer.network.ReviewsService
import org.almiso.nyt.moview.reviews.objects.ReviewResponse
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class ReviewsManager(service: ReviewsService) {
    companion object {
        const val TAG = "ReviewsManager"
    }


    /*
     * Fields
     */
    protected val mService: ReviewsService = service


    /*
     * Public methods
     */
    fun loadReviews() {
        mService.loadReviews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { throwable -> Observable.error<ReviewResponse>(throwable) }
                .subscribe(
                        { response -> Log.d(TAG, "response: $response") },
                        { error -> Log.d(TAG, "error: $error") },
                        { Log.d(TAG, "completed") }
                )
    }
}
