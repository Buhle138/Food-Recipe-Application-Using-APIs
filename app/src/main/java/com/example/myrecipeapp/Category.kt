package com.example.myrecipeapp

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

//Creating a list of objects
data class CategoriesResponse(val categories: List<Category>)
