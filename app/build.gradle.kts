
plugins {
    id(BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = (ProjectConfigs.COMPILE_SDK)

    defaultConfig {
        applicationId = (ProjectConfigs.APPLICATION_ID)
        minSdk = (ProjectConfigs.MIN_SDK)
        targetSdk = (ProjectConfigs.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-common.txt",
                "proguard-specific.txt"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER_VERSION
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

dependencies {

    implementation(Lib.Kotlin.KTX_CORE)
    implementation(Lib.Android.COMPOSE_UI)
    implementation(Lib.Android.COMPOSE_MATERIAL)
    implementation(Lib.Android.COMPOSE_MATERIAL_1x)
    implementation(Lib.Android.COMPOSE_TOOLING_PREVIEW)
    implementation(Lib.Android.COMPOSE_ACTIVITY)
    implementation(project( ":domain"))
    implementation(project(":data"))
    implementation(project(":navigator"))
    testImplementation(Lib.Test.JUNIT)
    androidTestImplementation(Lib.Test.ANDROID_JUNIT)
    androidTestImplementation(Lib.Test.ESPRESSO_CORE)
    androidTestImplementation(Lib.Test.COMPOSE_TEST_JUNIT)
    debugImplementation(Lib.Android.COMPOSE_TOOLING)
    debugImplementation(Lib.Android.COMPOSE_MANIFEST)

    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-beta01")
    /*DI*/
    implementation(Lib.DI.HILT_ANDROID)
    implementation(Lib.DI.HILT_NAVIGATION_COMPOSE)
    kapt(Lib.DI.HILT_COMPILER)
    kapt(Lib.DI.HILT_ANDROID_COMPILER)
}