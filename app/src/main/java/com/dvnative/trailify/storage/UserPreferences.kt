package com.dvnative.trailify.storage

import android.content.Context
import java.util.prefs.Preferences
import javax.sql.DataSource

data class UserPreferences(
    val isUserLogged: Boolean,
    val selectedTheme: String
)

private const val USER_PREFERENCES_NAME = "user_preferences"


//private val Context.dataStore by preferencesDataStore(
//    name = USER_PREFERENCES_NAME
//)
//
//class USerPreferencesRepository(
//    private val dataStore: DataStore<Preferences>
//)