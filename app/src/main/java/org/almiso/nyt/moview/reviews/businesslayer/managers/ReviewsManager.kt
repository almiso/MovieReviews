package org.almiso.nyt.moview.reviews.businesslayer.managers

import android.util.Log
import org.almiso.nyt.moview.reviews.businesslayer.managers.events.AbstractEvent
import org.almiso.nyt.moview.reviews.businesslayer.managers.events.ReviewsEvent
import org.almiso.nyt.moview.reviews.businesslayer.network.ReviewsService
import org.almiso.nyt.moview.reviews.objects.ReviewResponse
import org.greenrobot.eventbus.EventBus
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
                        { response -> post(ReviewsEvent(AbstractEvent.SUCCESS, response)) },
                        { error -> post(ReviewsEvent(AbstractEvent.ERROR, null, error)) },
                        { Log.d(TAG, "completed") }
                )
    }


    /*
     * Protected methods
     */
    protected fun post(event: AbstractEvent<*>) {
        EventBus.getDefault().post(event)
    }
}
