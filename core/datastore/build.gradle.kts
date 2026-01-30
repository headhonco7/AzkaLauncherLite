plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.nowinandroid.hilt)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.karuhun.core.datastore"
}

dependencies {
    api(projects.core.model)
    api(projects.core.datastoreProto)
    api(libs.androidx.dataStore)
    implementation(projects.core.common)

}