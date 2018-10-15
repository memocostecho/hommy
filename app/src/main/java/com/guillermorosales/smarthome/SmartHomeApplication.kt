package com.guillermorosales.smarthome

import android.app.Application
import com.guillermorosales.smarthome.di.appModule
import org.koin.android.ext.android.startKoin

class SmartHomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule))
    }
}