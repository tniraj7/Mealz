package com.nirajtiwari.composepractise.di

import com.nirajtiwari.composepractise.model.MealsRepository
import com.nirajtiwari.composepractise.network.GetMealCategoriesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DependencyModule {

    @Provides
    fun provideMealRepository(): MealsRepository = MealsRepository.getInstance()

    @Provides
    fun provideMealCategoriesService(): GetMealCategoriesService = GetMealCategoriesService()

    @Provides
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideBaseUrl(): String = "https://www.themealdb.com/api/json/v1/1/"

    @Provides
    fun provideRetrofit(BASE_URL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}