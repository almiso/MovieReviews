package org.almiso.nyt.moview.reviews.businesslayer.managers.events

import org.almiso.nyt.moview.reviews.objects.ReviewResponse

open class ReviewsEvent(status: Int, response: ReviewResponse?, error: Throwable? = null) : AbstractEvent<ReviewResponse>(status, response, error)
