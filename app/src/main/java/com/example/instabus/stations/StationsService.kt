package com.example.instabus.stations

import com.example.instabus.models.Data
import retrofit2.Response
import retrofit2.http.GET

interface StationsService {

    @GET("/bus/nearstation/latlon/%2041.3985182/2.1917991/1.json")
    suspend fun getStationData():Response<Data>
}