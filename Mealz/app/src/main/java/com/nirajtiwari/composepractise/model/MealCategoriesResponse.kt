package com.nirajtiwari.composepractise.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MealCategoriesResponse(
    @SerializedName("categories") val categories: List<Category>
)

@Keep
data class Category(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)