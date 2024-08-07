package com.example.iti_tasks_android.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPrefManager {
    private var sharedPref: SharedPreferences? = null
    private const val SHARED_PREF_NAME = "sharedPreference"
    private const val PHONE_KEY = "phoneKey"
    private const val MESSAGE_KEY = "messageKey"

    fun init(context: Context): SharedPreferences {
        return sharedPref ?: kotlin.run {
            sharedPref = context.getSharedPreferences(
                SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
            sharedPref!!
        }
    }

    fun clearSharedPref() {
        sharedPref?.edit()?.clear()?.apply()
    }

    var phone: Int
        get() = sharedPref?.getInt(PHONE_KEY, 0) ?: 0
        set(value) = sharedPref?.edit()?.putInt(PHONE_KEY, value)?.apply() ?: Unit

    var message: String
        get() = sharedPref?.getString(MESSAGE_KEY, "") ?: ""
        set(value) = sharedPref?.edit()?.putString(MESSAGE_KEY, value)?.apply() ?: Unit
}