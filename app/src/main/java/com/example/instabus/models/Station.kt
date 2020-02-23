package com.example.instabus.models


import android.os.Parcel
import android.os.Parcelable

class Station (
    val id: Int,
    val street_name: String,
    val city: String,
    val utm_x:String,
    val utm_y:String,
    val lat:String,
    val lon:String,
    val furniture:String,
    val buses:String,
    val distance:String

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(street_name)
        parcel.writeString(city)
        parcel.writeString(utm_x)
        parcel.writeString(utm_y)
        parcel.writeString(lat)
        parcel.writeString(lon)
        parcel.writeString(furniture)
        parcel.writeString(buses)
        parcel.writeString(distance)
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