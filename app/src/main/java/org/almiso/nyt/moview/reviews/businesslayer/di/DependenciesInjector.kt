package org.almiso.nyt.moview.reviews.businesslayer.di

import dagger.Component
import org.almiso.nyt.moview.reviews.businesslayer.fragments.ReviewsFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [DependenciesFactory::class])
interface DependenciesInjector {
    fun inject(fragment: ReviewsFragment)
}
