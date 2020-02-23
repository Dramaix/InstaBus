package com.example.instabus.models

import com.squareup.moshi.Json

data class Drink (@Json(name = "drinks") val cocktails: List<Station>? = emptyList())  {

}
