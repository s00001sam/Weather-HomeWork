package com.sam.gogozoo.ext

import android.app.Activity
import android.view.Gravity
import android.widget.Toast
import com.sam.weather.MyApplication
import com.sam.weather.factory.ViewModelFactory


fun Activity.getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as MyApplication).repository
    return ViewModelFactory(repository)
}

fun Activity?.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).apply {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}