package com.nirajtiwari.composepractise.network

import com.nirajtiwari.composepractise.di.DaggerDependencyComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GetMealCategoriesService {

    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    @Inject
    lateinit var client: OkHttpClient

    init {
        DaggerDependencyComponent.create().inject(this)
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildMealCategoriesService() : GetMealCategoriesAPI {
        return api.create(GetMealCategoriesAPI::class.java)
    }

}
