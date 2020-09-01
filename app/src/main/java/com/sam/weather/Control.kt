package com.sam.weather

import android.content.Context

object Control {

    private const val FIRST = "FirstTime"

    var isFirstTime: Boolean?
        get() = MyApplication.INSTANCE
            .getSharedPreferences(FIRST, Context.MODE_PRIVATE)
            .getBoolean(FIRST, true)
        set(value) = MyApplication.INSTANCE
            .getSharedPreferences(FIRST, Context.MODE_PRIVATE)
            .edit().putBoolean(FIRST, value!!)
            .apply()

}