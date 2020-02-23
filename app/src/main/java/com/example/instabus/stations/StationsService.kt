package com.example.instabus.stations

import com.example.instabus.models.Drink
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StationsService {
    @GET("filter.php?c=Cocktail")
    suspend fun getAllCocktails(): Response<Drink>

    @GET("search.php")
    suspend fun getCocktailsFilteredByName(@Query("s") name: String): Response<Drink>

}