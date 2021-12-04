package com.nirajtiwari.composepractise.ui.mealsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

@Composable
fun MealDetailsScreen(meal: Category) {
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(
                        data = meal.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(text = meal.name)
        }

        Button(onClick = {

        }) {
            Text("Change state of meal image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePractiseTheme {
        MealDetailsScreen(meal = Category("1", "vegeterian", "adfa", ""))
    }
}