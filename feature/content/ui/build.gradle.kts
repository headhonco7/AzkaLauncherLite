plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "com.karuhun.feature.content.ui"
}

dependencies {
    implementation(projects.core.domain)
}