plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = (ProjectConfigs.COMPILE_SDK)

    defaultConfig {
        minSdk = (ProjectConfigs.MIN_SDK)
        targetSdk = (ProjectConfigs.TARGET_SDK)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

dependencies {
    implementation(Lib.Android.APP_COMPAT)
    implementation(Lib.Kotlin.KTX_CORE)
    api(Lib.Async.COROUTINES)
    api(Lib.Async.COROUTINES_ANDROID)

    implementation(Lib.Kotlin.KT_STD)
    implementation(Lib.Android.COMPOSE_NAVIGATION)

    implementation(Lib.Android.COMPOSE_NAVIGATION)
    implementation(Lib.DI.HILT_NAVIGATION_COMPOSE)
}