# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep all protobuf classes and their fields
-keep class com.karuhun.core.datastore.** { *; }

# Keep protobuf lite runtime
-keep class com.google.protobuf.** { *; }
-keepclassmembers class com.google.protobuf.** { *; }

# Keep protobuf generated classes
-keep class * extends com.google.protobuf.GeneratedMessageLite { *; }
-keepclassmembers class * extends com.google.protobuf.GeneratedMessageLite {
    <fields>;
    <methods>;
}

# Keep protobuf field names (important for reflection-based access)
-keepclassmembers class * extends com.google.protobuf.GeneratedMessageLite {
    *** *_;
}

# Keep enum classes used in protobuf
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep ChangeListVersions data class and its properties (fixes ClassCastException)
-keep class com.karuhun.core.datastore.* { *; }
-keepclassmembers class com.karuhun.core.datastore.* {
    *;
}

# Keep all datastore related classes

# Keep Kotlin property references (used in sync repositories)
-keepclassmembers class ** {
    kotlin.jvm.functions.Function1 *;
    kotlin.reflect.KProperty1 *;
}

# Keep Kotlin reflection for property references
-keep class kotlin.reflect.** { *; }
-keep class kotlin.jvm.internal.** { *; }
-keepclassmembers class kotlin.Metadata {
    *;
}

# Keep DataStore related classes
-keep class androidx.datastore.** { *; }
-keepclassmembers class androidx.datastore.** { *; }
