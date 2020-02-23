package com.example.instabus.stations

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instabus.R
import com.example.instabus.models.Station
import kotlinx.android.synthetic.main.content_station_detail.*
import kotlinx.android.synthetic.main.toolbar.*

@SuppressLint("Registered")
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class StationsDetailActivity : AppCompatActivity() {

    lateinit var station: Station

    companion object {
        const val EXTRA_STATION = "Station"

        fun start(context: Context, station: Station) {
            val intent = Intent(context, StationsDetailActivity::class.java)
                .putExtra(EXTRA_STATION, station)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        station = intent.getParcelableExtra(EXTRA_STATION)

        station_image
        station_name.text = station.street_name
        city_name.text = station.city
        longitude_name.text = station.lon
        latitude_name.text = station.lat
    }

}