package com.nirajtiwari.composepractise.ui.meals

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

@Composable
fun MealsCategoriesScreen(name: String) {
    val viewModel: MealsCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value
    LazyColumn {
        items(meals) { meal ->
            Text("${meal.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePractiseTheme {
        MealsCategoriesScreen("Android")
    }
}