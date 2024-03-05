package com.dvnative.trailify.storage

import android.content.Context

class Prefs {
    companion object {
        const val PREFERENCES_FILE = "pref_file"
        const val FORCED_COUNTRY = "forcedCountry"
        const val USER = "userData"

        fun setForcedCountry(c: Context, country: String?) {
            val preferences = c.getSharedPreferences(
                PREFERENCES_FILE,
                Context.MODE_PRIVATE
            )
            val editor = preferences.edit()
            editor.putString(FORCED_COUNTRY, country)
            editor.apply()
        }

        fun getForcedCountry(c: Context): String? {
            val preferences = c.getSharedPreferences(
                PREFERENCES_FILE,
                Context.MODE_PRIVATE
            )
            return preferences.getString(FORCED_COUNTRY, "IT")
        }

        fun saveUser(c: Context, serializedUser: String) {
            val preferences = c.getSharedPreferences(
                PREFERENCES_FILE,
                Context.MODE_PRIVATE
            )
            val editor = preferences.edit()
            editor.putString(USER, serializedUser)
            editor.apply()
        }

        fun loadUser(c: Context): String? {
            val preferences = c.getSharedPreferences(
                PREFERENCES_FILE,
                Context.MODE_PRIVATE
            )
            return preferences.getString(USER, "")
        }
    }
}