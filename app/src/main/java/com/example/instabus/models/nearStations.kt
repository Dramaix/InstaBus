package com.example.instabus.models

import com.squareup.moshi.Json

class nearStations (@Json(name = "nearstations") val stations: List<Station>? = emptyList()) {

}