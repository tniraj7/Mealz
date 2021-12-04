package com.nirajtiwari.composepractise.ui.mealsdetails

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme

@Composable
fun MealDetailsScreen(meal: Category?) {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column {
            Row {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(
                        2.dp,
                        Color.Blue
                    )
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = meal?.imageUrl,
                            builder = {
                                transformations(CircleCropTransformation())
                            }),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(16.dp)
                    )
                }
                Text(
                    text = meal?.name ?: "",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }

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

enum class MealImageState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(color = Color.Magenta, 120.dp, 8.dp),
    Expanded(color = Color.Green, 200.dp, 24.dp)
}