package com.nirajtiwari.composepractise.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.nirajtiwari.composepractise.ui.meals.MealsCategoriesScreen
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractiseTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MealsCategoriesScreen("Android")
                }
            }
        }
    }
}

