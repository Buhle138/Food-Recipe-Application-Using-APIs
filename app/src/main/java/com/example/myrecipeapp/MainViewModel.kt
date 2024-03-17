package com.example.myrecipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel(){

    //Creating a data class that will take care of the state of the recipes
    //We need to know whether we have the recipes or not.
    private val _categorieState = mutableStateOf(RecipeState())

    //Exposing the categorieState variable to other classes.
    val categoriesState: State<RecipeState> = _categorieState


    init {
        fetchCategories()
    }

    //function to fetch the categories
    private fun fetchCategories(){
        //Coroutine allows  you to run code in the background.
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null //Question mark after the string means that the variable can be null.
    )

}