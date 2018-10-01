package org.almiso.nyt.moview.reviews.businesslayer.di

import dagger.Module
import dagger.Provides
import org.almiso.nyt.moview.reviews.businesslayer.managers.ReviewsManager
import javax.inject.Singleton

@Module
open class DependenciesFactory {

    @Provides
    @Singleton
    fun reviewsmanager(): ReviewsManager {
        return ReviewsManager()
    }

}
