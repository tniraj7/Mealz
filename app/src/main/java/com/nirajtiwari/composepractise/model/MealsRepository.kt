package com.nirajtiwari.composepractise.model

import com.nirajtiwari.composepractise.di.DaggerDependencyComponent
import com.nirajtiwari.composepractise.network.GetMealCategoriesService
import javax.inject.Inject

class MealsRepository {

    @Inject
    lateinit var service: GetMealCategoriesService
    private var cachedMeals = listOf<Category>()

    init {
        DaggerDependencyComponent.create().inject(this)
    }

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