package com.example.onboarding_demo.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow

interface PreferenceStorage {

    suspend fun save(screen: String)
    suspend fun saveTags(tags: Set<String>)
    val isOnboarded: Flow<String>
    val tags: Flow<Set<String>>

    object PreferencesKey{

        val PREF_ONBOARDED = stringPreferencesKey("onboarded")
        val PREF_TAGS = stringSetPreferencesKey("tags")
    }
}