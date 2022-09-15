import Lib.Kotlin.KOTLIN_VERSION

object BuildPlugins {
    private const val TOOLS_BUILD = "7.2.1"
    private const val KT_LINT = "9.2.1"

    const val TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:${TOOLS_BUILD}"
    const val KTLINT_GRADLE_PLUGIN = "org.jlleitschuh.gradle:ktlint-gradle:${KT_LINT}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KOTLIN_VERSION}"
    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
    const val KOTLIN_PARCELABLE_PLUGIN = "kotlin-parcelize"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val DAGGER_HILT = "dagger.hilt.android.plugin"
    const val DAGGER_HILT_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${Lib.DI.DAGGER_VERSION}"
    const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
}

object Lib {
    object Android {
        private const val COMPOSE_VERSION = "1.2.0"
        private const val MATERIAL_DESIGN_VERSION = "1.0.0-alpha01"
        const val COMPOSE_COMPILER_VERSION = COMPOSE_VERSION
        private const val COMPOSE_ACTIVITY_VERSION = "1.4.0"
        private const val COMPOSE_NAVIGATION_VERSION = "2.5.0-alpha01"

        const val COMPOSE_UI = "androidx.compose.ui:ui:${COMPOSE_VERSION}"
        const val COMPOSE_MATERIAL = "androidx.compose.material3:material3:${MATERIAL_DESIGN_VERSION}"
        const val COMPOSE_TOOLING_PREVIEW =
            "androidx.compose.ui:ui-tooling-preview:${COMPOSE_VERSION}"
        const val COMPOSE_ACTIVITY =
            "androidx.activity:activity-compose:${COMPOSE_ACTIVITY_VERSION}"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${COMPOSE_VERSION}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${COMPOSE_VERSION}"
        const val PAGING_KTX = "androidx.paging:paging-common-ktx:3.1.0"
        const val COMPOSE_NAVIGATION =
            "androidx.navigation:navigation-compose:${COMPOSE_NAVIGATION_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.0-beta01"
    }

    object Room {
        private const val ROOM_VERSION = "2.4.1"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
        const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VERSION"
        const val ROOM_PAGING = "androidx.room:room-paging:$ROOM_VERSION"
    }

    object Kotlin {
        const val KOTLIN_VERSION = "1.7.0"
        private const val KTX_CORE_VERSION = "1.7.0"

        const val KTX_CORE = "androidx.core:core-ktx:${KTX_CORE_VERSION}"
        const val KT_STD = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KOTLIN_VERSION}"
    }

    object DI {
        const val DAGGER_VERSION = "2.43"

        const val HILT_ANDROID = "com.google.dagger:hilt-android:${DAGGER_VERSION}"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:${DAGGER_VERSION}"
        const val HILT_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"
        const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val HILT_CORE = "com.google.dagger:hilt-core:$DAGGER_VERSION"
    }

    object Test {
        private const val JUNIT_VERSION = "4.13.2"
        private const val ANDROID_JUNIT_VERSION = "1.1.3"
        private const val ESPRESSO_VERSION = "3.4.0"
        private const val COMPOSE_UI_JUNIT = "4:1.2.0"

        const val JUNIT = "junit:junit:${JUNIT_VERSION}"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${ANDROID_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${ESPRESSO_VERSION}"
        const val COMPOSE_TEST_JUNIT = "androidx.compose.ui:ui-test-junit${COMPOSE_UI_JUNIT}"
    }

    object Async {
        private const val COROUTINES_VERSION = "1.6.0"

        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${COROUTINES_VERSION}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${COROUTINES_VERSION}"
    }
}