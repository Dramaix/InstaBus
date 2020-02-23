package com.example.instabus.stations

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.instabus.models.Station
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.example.instabus.WEB_SERVICE_URL

class StationRepository (val app: Application) {
    val stationdata = MutableLiveData<List<Station>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            callwebservice()
        }
    }

    @WorkerThread
    suspend fun callwebservice(){
        val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder().baseUrl(WEB_SERVICE_URL).addConverterFactory(
            MoshiConverterFactory.create(moshi)).build()
        val service = retrofit.create(StationsService::class.java)
        val serviceData =service.getStationData().body()
        stationdata.postValue(serviceData?.nearStations?.stations)
    }
    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting?:false
    }
}
