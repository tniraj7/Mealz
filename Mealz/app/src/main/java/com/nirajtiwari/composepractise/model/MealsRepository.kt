package com.nirajtiwari.composepractise.model

import com.nirajtiwari.composepractise.network.GetMealCategoriesService

class MealsRepository(private val service: GetMealCategoriesService = GetMealCategoriesService()) {

    suspend fun getMeals(): MealCategoriesResponse? {
        return  service.buildMealCategoriesService().getMealCategories().body()
    }

}