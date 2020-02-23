package com.example.instabus.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Station(
    @Json(name = "id") val id: Int,
    @Json(name = "street_name") val name: String?,
    @Json(name = "city") val name_city: String?,
    @Json(name = "lon") val longitude: Int,
    @Json(name = "lat") val latitude: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(name_city)
        parcel.writeInt(longitude)
        parcel.writeInt(latitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Station> {
        override fun createFromParcel(parcel: Parcel): Station {
            return Station(parcel)
        }

        override fun newArray(size: Int): Array<Station?> {
            return arrayOfNulls(size)
        }
    }
}