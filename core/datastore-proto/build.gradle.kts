plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.karuhun.core.datastore.proto"

    defaultConfig {
        consumerProguardFiles("proguard-rules.pro")
    }
}

// Setup protobuf configuration, generating lite Java and Kotlin classes
protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    api(libs.protobuf.kotlin.lite)
}
