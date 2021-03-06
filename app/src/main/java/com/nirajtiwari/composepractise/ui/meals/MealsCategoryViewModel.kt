package com.nirajtiwari.composepractise.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nirajtiwari.composepractise.di.DaggerDependencyComponent
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.model.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealsCategoryViewModel : ViewModel() {

    @Inject
    lateinit var repository: MealsRepository

    val mealsState: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())

    init {

        DaggerDependencyComponent.create().inject(this)

        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    private suspend fun getMeals(): List<Category> {
        return repository?.getMeals()?.categories!!
    }
}
