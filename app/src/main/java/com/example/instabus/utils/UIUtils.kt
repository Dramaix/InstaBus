package com.example.instabus.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun showSnackbar(view: View, text: String) {
    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    Snackbar
        .make(view, text, Snackbar.LENGTH_SHORT)
        .show()
}
