plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.nowinandroid.hilt)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("kotlinx-serialization")
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.karuhun.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

secrets {
    defaultPropertiesFileName = "app.properties"
}

dependencies {
    api(libs.kotlinx.datetime)
    api(projects.core.common)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.converter.gson)

    testImplementation(libs.kotlinx.coroutines.test)
}
