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
            instanceFollowRedirects = true
            setRequestProperty("Accept", "application/json")
        }

        try {
            val code = conn.responseCode
            if (code != 200) {
                // coba baca error body sedikit (kalau ada)
                val err = runCatching {
                    conn.errorStream?.bufferedReader()?.use { it.readText() } ?: ""
                }.getOrDefault("")
                val snippet = err.take(200)
                throw RuntimeException("HTTP $code when fetching config from ${url}. Body: $snippet")
            }

            val body = conn.inputStream.bufferedReader().use { it.readText() }.trim()

            // Guard ringan: kalau ternyata HTML (umum terjadi di 404 GitHub Pages/path salah)
            if (body.startsWith("<!DOCTYPE html", ignoreCase = true) ||
                body.startsWith("<html", ignoreCase = true)
            ) {
                throw RuntimeException("Config fetch returned HTML (likely wrong URL/path): ${url}")
            }

            // Guard ringan: pastikan terlihat seperti JSON object
            if (!body.startsWith("{")) {
                throw RuntimeException("Config fetch returned non-JSON content from ${url}: ${body.take(120)}")
            }

            return body
        } finally {
            conn.disconnect()
        }
    }
}
