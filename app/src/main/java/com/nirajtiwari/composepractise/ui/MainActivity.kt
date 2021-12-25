package com.nirajtiwari.composepractise.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nirajtiwari.composepractise.ui.meals.MealsCategoriesScreen
import com.nirajtiwari.composepractise.ui.mealsdetails.MealDetailsScreen
import com.nirajtiwari.composepractise.ui.mealsdetails.MealDetailsViewModel
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractiseTheme {
                Surface(color = MaterialTheme.colors.background) {
                    FoodApp()
                }
            }
        }
    }
}

@Composable
private fun FoodApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen { mealId ->
                navController.navigate("destination_meal_details/$mealId")
            }
        }

        composable(
            route = "destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            }),
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}

