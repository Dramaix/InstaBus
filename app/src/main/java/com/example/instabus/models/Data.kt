package com.example.instabus.models

import com.squareup.moshi.Json

class Data(@Json(name = "data" )val nearStations: nearStations?=nearStations()) {
}