package com.nirajtiwari.composepractise.ui.mealsdetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.model.MealsRepository

class MealDetailsViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()
    val mealState = mutableStateOf<Category?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}