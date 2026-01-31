package com.karuhun.launcher.model

// Root config
data class Config(
    val propertyName: String = "",
    val city: String = "",
    val wifi: Wifi = Wifi(),
    val whatsapp: Whatsapp = Whatsapp(),
    val text: Text = Text(),
    val ui: Ui = Ui(),
    val branding: Branding = Branding()
)

// --- Sub models ---

data class Wifi(
    val ssid: String = "",
    val password: String = ""
)

data class Whatsapp(
    val number: String = "",
    val message: String = ""
)

data class Text(
    val runningText: String = ""
)

data class Ui(
    val theme: String = "" // disiapkan, belum dipakai
)

data class Branding(
    val wallpaperUrl: String = "",
    val logoUrl: String = ""
)
