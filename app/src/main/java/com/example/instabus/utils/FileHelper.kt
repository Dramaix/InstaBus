package com.example.instabus.utils

import android.content.Context

class FileHelper {

    companion object {
        fun getTextFromResources(context: Context, resouseId: Int): String {
            return context.resources.openRawResource(resouseId).use { iStream ->
                iStream.bufferedReader().use { bReader ->
                    bReader.readText()
                }
            }
        }

        fun getTextFromAssets(context: Context, fineName: String): String {
            return context.assets.open(fineName).use { iStream ->
                iStream.bufferedReader().use { bReader ->
                    bReader.readText()
                }
            }
        }


    }

}