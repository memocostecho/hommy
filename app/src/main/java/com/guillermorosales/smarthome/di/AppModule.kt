package com.guillermorosales.smarthome.di

import com.google.firebase.database.FirebaseDatabase
import com.guillermorosales.smarthome.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * App Koin DI module
 */
val appModule = module {

    // Firebase database
    single {
        FirebaseDatabase.getInstance()
    }

    // main view model
    viewModel { MainViewModel(get()) }

}