package com.karuhun.launcher.data

import android.content.Context
import com.karuhun.launcher.model.Config
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

    /**
     * Mengembalikan Config object terbaik yang tersedia.
     * - Ambil raw JSON terbaik (remote/cache)
     * - Parse jadi Config
     * - Jika parse remote gagal, coba parse cache (kalau ada)
     * - Jika tetap gagal, fallback Config() agar app tetap jalan (compile & runtime lebih aman)
     */
    suspend fun getBestConfig(): Pair<Config, String> = withContext(Dispatchers.IO) {
        val (raw, source) = getBestConfigRawJson()

        val parsed: Config? = try {
            ConfigJsonParser.parse(raw)
        } catch (e: Exception) {
            // Kalau yang gagal itu remote, coba parse cache (kalau ada)
            if (source == "remote") {
                val cached = storage.loadRawJson()
                if (!cached.isNullOrBlank()) {
                    try {
                        ConfigJsonParser.parse(cached)
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    null
                }
            } else {
                null
            }
        }

        (parsed ?: Config()) to source
    }
}
