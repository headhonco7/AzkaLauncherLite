package com.karuhun.launcher.data

import com.karuhun.launcher.model.RemoteConfigConstants
import java.net.HttpURLConnection
import java.net.URL

class ConfigFetcher {

    fun fetchRawJson(): String {
        val url = URL(RemoteConfigConstants.CONFIG_URL)
        val conn = (url.openConnection() as HttpURLConnection).apply {
            connectTimeout = 8000
            readTimeout = 8000
            requestMethod = "GET"
        }

        try {
            val code = conn.responseCode
            if (code != 200) {
                throw RuntimeException("HTTP $code when fetching config")
            }
            return conn.inputStream.bufferedReader().use { it.readText() }
        } finally {
            conn.disconnect()
        }
    }
}
