package com.example.onboarding_demo.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.onboarding_demo.datastore.PreferenceStorage.PreferencesKey.PREF_ONBOARDED
import com.example.onboarding_demo.datastore.PreferenceStorage.PreferencesKey.PREF_TAGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStorePreferenceStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
): PreferenceStorage {

    companion object {
        const val PREFS_NAME = "onboarding_prefs"
    }

    override suspend fun save(screen: String) {

        dataStore.edit { settings ->
            settings[PREF_ONBOARDED] = screen
        }
    }

    override suspend fun saveTags(tags: Set<String>) {
        dataStore.edit { settings ->
            settings[PREF_TAGS] = tags
        }
    }

    override val isOnboarded: Flow<String> =
        dataStore.data.map { it[PREF_ONBOARDED] ?: "" }

    override val tags: Flow<Set<String>>
        get() = dataStore.data.map { it[PREF_TAGS] ?: setOf() }
}