package com.nirajtiwari.composepractise.model

import com.nirajtiwari.composepractise.network.GetMealCategoriesService

class MealsRepository(private val service: GetMealCategoriesService = GetMealCategoriesService()) {

    private var cachedMeals = listOf<Category>()

    companion object {
        @Volatile
        private  var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }

    suspend fun getMeals(): MealCategoriesResponse? {
        val response = service.buildMealCategoriesService().getMealCategories().body()
        if (response != null) {
            cachedMeals = response.categories
        }
        return response
    }

    fun getMeal(id: String): Category? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }
}