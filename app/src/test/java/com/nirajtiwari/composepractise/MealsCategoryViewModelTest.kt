package com.nirajtiwari.composepractise

import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.model.MealsRepository
import com.nirajtiwari.composepractise.ui.meals.MealsCategoryViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MealsCategoryViewModelTest {

    @Mock
    lateinit var repository: MealsRepository

    @InjectMocks
    var mealsCategoryViewModel = MealsCategoryViewModel()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getMealsSuccess() = runBlockingTest {

        val meal = Category("1", "a meal", "bla bla bla", "https://a-meal-url.com")
        val mealsList = arrayListOf(meal)

        `when`(repository.getMeals()?.categories).thenReturn(mealsList)

        Assert.assertEquals(1, mealsCategoryViewModel.repository.getMeals()?.categories?.size)
    }
}