package com.mutualmobile.swiggy_clone

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SwiggyApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}