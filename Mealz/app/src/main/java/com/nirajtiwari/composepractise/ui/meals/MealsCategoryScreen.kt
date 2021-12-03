package com.nirajtiwari.composepractise.ui.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

@Composable
fun MealsCategoriesScreen(name: String) {
    val viewModel: MealsCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(meals) { meal ->
            MealCategory(meal = meal)
        }
    }
}

@Composable
fun MealCategory(meal: Category) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ) {
        Row {

            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = "",
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
            }
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