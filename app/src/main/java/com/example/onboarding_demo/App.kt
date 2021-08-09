package com.example.onboarding_demo

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.onboarding_demo.datastore.DataStorePreferenceStorage
import com.example.onboarding_demo.datastore.DataStorePreferenceStorage.Companion.PREFS_NAME
import com.example.onboarding_demo.datastore.PreferenceStorage
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@HiltAndroidApp
class App: Application() {
}