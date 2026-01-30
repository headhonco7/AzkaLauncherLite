plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "com.karuhun.feature.mainmenu.ui"
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.coil.kt.svg)
}