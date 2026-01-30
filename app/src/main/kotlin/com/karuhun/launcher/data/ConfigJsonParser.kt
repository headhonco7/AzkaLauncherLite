package com.karuhun.launcher.data

import com.karuhun.launcher.model.Config
import com.karuhun.launcher.model.Text
import com.karuhun.launcher.model.Ui
import com.karuhun.launcher.model.Whatsapp
import com.karuhun.launcher.model.Wifi
import org.json.JSONObject
import com.karuhun.launcher.model.Branding

object ConfigJsonParser {

    fun parse(raw: String): Config {
        val root = JSONObject(raw)
        val brandingObj = root.optJSONObject("branding") ?: JSONObject()
        val wifiObj = root.optJSONObject("wifi") ?: JSONObject()
        val waObj = root.optJSONObject("whatsapp") ?: JSONObject()
        val textObj = root.optJSONObject("text") ?: JSONObject()
        val uiObj = root.optJSONObject("ui") ?: JSONObject()

        return Config(
            branding = Branding(
                wallpaperUrl = brandingObj.optString("wallpaperUrl", ""),
                logoUrl = brandingObj.optString("logoUrl", "")
            )
            propertyName = root.optString("propertyName", ""),
            city = root.optString("city", ""),
            wifi = Wifi(
                ssid = wifiObj.optString("ssid", ""),
                password = wifiObj.optString("password", "")
            ),
            whatsapp = Whatsapp(
                number = waObj.optString("number", ""),
                label = waObj.optString("label", "")
            ),
            text = Text(
                welcomeHome = textObj.optString("welcomeHome", ""),
                runningText = textObj.optString("runningText", "")
            ),
            ui = Ui(
                cardZoomEnabled = uiObj.optBoolean("cardZoomEnabled", true),
                qrEnabled = uiObj.optBoolean("qrEnabled", true)
            )
        )
    }
}
