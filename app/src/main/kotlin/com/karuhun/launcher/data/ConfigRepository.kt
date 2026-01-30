package com.karuhun.launcher.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.karuhun.launcher.model.Config

class ConfigRepository(
    context: Context,
    private val fetcher: ConfigFetcher = ConfigFetcher(),
    private val storage: ConfigStorage = ConfigStorage(context)
) {

    /**
     * Mengembalikan JSON terbaik yang tersedia.
     * - Prioritas: remote (kalau sukses)
     * - Fallback: cache (kalau remote gagal)
     *
     * Return: Pair(rawJson, source) -> source: "remote" / "cache"
     */
    fun getBestConfigRawJson(): Pair<String, String> {
        val cached = storage.loadRawJson()

        return try {
            val remote = fetcher.fetchRawJson()
            // kalau fetch sukses, simpan sebagai last known good
            storage.saveRawJson(remote)
            remote to "remote"
        } catch (e: Exception) {
            // remote gagal: pakai cache jika ada
            if (!cached.isNullOrBlank()) {
                cached to "cache"
            } else {
                // tidak ada remote & tidak ada cache -> fail keras
                throw RuntimeException("No remote config and no cached config available", e)
            }
        }
    }
    suspend fun getBestConfig(): Pair<Config, String> = withContext(Dispatchers.IO) {
        val (raw, source) = getBestConfigRawJson()
        val config = ConfigJsonParser.parse(raw)
        config to source
}
}
