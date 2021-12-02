package com.nirajtiwari.composepractise.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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

@Composable
fun MealsCategoriesScreen(name: String) {
    val viewModel: MealsCategoryViewModel = viewModel()

    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePractiseTheme {
        MealsCategoriesScreen("Android")
    }
}