package com.example.instabus.stations

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class StationsViewModel(app: Application) : AndroidViewModel(app) {


    private val cocktailRepository = StationRepository(app)

    val cocktailsData = cocktailRepository.cocktailsData

    fun findCocktails(filter: String?) {
        if (filter != null) {
            cocktailRepository.getCocktailsFilteredByName(filter)
        } else {
            refreshData()
        }
    }

    fun refreshData() {
        cocktailRepository.refreshData()
    }

}