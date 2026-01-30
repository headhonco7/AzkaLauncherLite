package com.karuhun.launcher.data

import android.content.Context

class ConfigStorage(private val context: Context) {
    private val prefs by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveRawJson(raw: String) {
        prefs.edit().putString(KEY_RAW_JSON, raw).apply()
    }

    fun loadRawJson(): String? {
        return prefs.getString(KEY_RAW_JSON, null)
    }

    companion object {
        private const val PREF_NAME = "azka_launcher_prefs"
        private const val KEY_RAW_JSON = "last_known_good_config_json"
    }
}
