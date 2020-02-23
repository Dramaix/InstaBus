package com.example.instabus.stations

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.instabus.StationsServiceFactory
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instabus.R
import com.example.instabus.models.Station
import com.example.instabus.utils.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StationRepository (val app: Application) {
    private val TAG = "CocktailRepository"

    private var stationService = StationsServiceFactory.makeCocktailFactory()

    private val _stationsData = MutableLiveData<List<Station>?>()
    val cocktailsData: LiveData<List<Station>?>
        get() = _stationsData

    private val listType = Types.newParameterizedType(
        List::class.java, Station::class.java
    )

    fun getCocktailDataFromResources() {
        val textFromResources = FileHelper.getTextFromResources(app, R.raw.raw_station)

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<List<Station>> = moshi.adapter(listType)
        _stationsData.value = adapter.fromJson(textFromResources)?: emptyList()
    }

    fun getCocktailsFilteredByName(cocktailName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            callGetCocktailsFilteredByName(cocktailName)
        }
    }

    fun getAllCocktails() {
        CoroutineScope(Dispatchers.IO).launch {
            callGetAllCocktails()
        }
    }

    @WorkerThread
    private suspend fun callGetCocktailsFilteredByName(cocktailName: String) {
        if (networkAvailable()) {
            val response = stationService.getCocktailsFilteredByName(cocktailName).body()
            _stationsData.postValue(response?.cocktails)
        }
    }

    @WorkerThread
    private suspend fun callGetAllCocktails() {
        if (networkAvailable()) {
            val serviceData = stationService.getAllCocktails().body()
            _stationsData.postValue(serviceData?.cocktails)
        }
    }

    fun refreshData() {
        CoroutineScope(Dispatchers.IO).launch {
            callGetAllCocktails()
        }
    }

    @SuppressLint("ServiceCast", "MissingPermission")
    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting?:false
    }
}
