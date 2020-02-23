package com.example.instabus.stations

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class StationsViewModel(app: Application) : AndroidViewModel(app) {


    private val Data_repos=StationRepository(app)
    val station = Data_repos.stationdata


}