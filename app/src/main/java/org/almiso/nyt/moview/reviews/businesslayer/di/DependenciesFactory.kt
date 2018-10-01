package org.almiso.nyt.moview.reviews.businesslayer.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.almiso.nyt.moview.reviews.businesslayer.managers.ReviewsManager
import org.almiso.nyt.moview.reviews.businesslayer.network.ReviewsService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
open class DependenciesFactory {

    @Provides
    @Singleton
    internal fun retrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        return Retrofit.Builder()
                .baseUrl(ReviewsService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun reviewsService(retrofit: Retrofit): ReviewsService {
        return retrofit.create(ReviewsService::class.java)
    }


    @Provides
    @Singleton
    fun reviewsManager(service: ReviewsService): ReviewsManager {
        return ReviewsManager(service)
    }
}
