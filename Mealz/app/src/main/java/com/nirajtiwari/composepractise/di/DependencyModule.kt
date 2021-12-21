package com.nirajtiwari.composepractise.di

import com.nirajtiwari.composepractise.network.GetMealCategoriesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class DependencyModule {

    @Provides
    fun provideMealCategoriesService(): GetMealCategoriesService {
        return GetMealCategoriesService()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}