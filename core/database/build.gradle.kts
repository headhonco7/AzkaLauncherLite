plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.hilt)
    alias(libs.plugins.nowinandroid.android.room)
}

android {
    namespace = "com.karuhun.core.database"
}

dependencies {
    api(projects.core.model)
}