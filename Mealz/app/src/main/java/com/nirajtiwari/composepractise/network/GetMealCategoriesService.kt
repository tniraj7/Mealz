package com.nirajtiwari.composepractise.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object GetMealCategoriesService {

    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildMealCategoriesService() : GetMealCategoriesAPI {
        return api.create(GetMealCategoriesAPI::class.java)
    }

}
