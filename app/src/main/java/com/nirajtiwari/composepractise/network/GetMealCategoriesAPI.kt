package com.nirajtiwari.composepractise.network

import com.nirajtiwari.composepractise.model.MealCategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetMealCategoriesAPI {

    @GET("categories.php")
    suspend fun getMealCategories(): Response<MealCategoriesResponse>
}