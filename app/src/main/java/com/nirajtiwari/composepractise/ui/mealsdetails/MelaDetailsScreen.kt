package com.nirajtiwari.composepractise.ui.mealsdetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.nirajtiwari.composepractise.model.Category
import com.nirajtiwari.composepractise.ui.theme.ComposePractiseTheme
import java.lang.Float.min

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MealDetailsScreen(meal: Category?) {

    val scrollState = rememberLazyListState()
    val offset = min(1f, 1- (scrollState.firstVisibleItemScrollOffset/600f + scrollState.firstVisibleItemIndex))
    val size by animateDpAsState(targetValue = max(100.dp, 140.dp * offset))

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
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
                                .size(size)
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

            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList) { item ->
                    Text(item, modifier = Modifier.padding(24.dp))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
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