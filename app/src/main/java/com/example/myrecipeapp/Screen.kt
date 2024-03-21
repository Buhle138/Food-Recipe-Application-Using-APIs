package com.example.myrecipeapp


//This class takes care of the individual routes
sealed class Screen(val route:String) {

    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")

}