buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
        maven ( "https://jitpack.io" )
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.TOOLS_BUILD_GRADLE)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildPlugins.DAGGER_HILT_PLUGIN)
        classpath(kotlin("serialization", version =  Lib.Kotlin.KOTLIN_VERSION))
        classpath("com.android.tools.build:gradle:7.2.2")
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.

allprojects {
    repositories {
        google()
        mavenCentral()
        maven ( "https://jitpack.io" )
        maven("https://plugins.gradle.org/m2/")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}