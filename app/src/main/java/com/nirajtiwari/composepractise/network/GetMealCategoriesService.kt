package com.nirajtiwari.composepractise.network

import com.nirajtiwari.composepractise.di.DaggerDependencyComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class GetMealCategoriesService {

    @Inject
    lateinit var api: Retrofit

    init {
        DaggerDependencyComponent.create().inject(this)
    }

    fun buildMealCategoriesService(): GetMealCategoriesAPI {
        return api.create(GetMealCategoriesAPI::class.java)
    }

}
