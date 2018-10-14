package com.guillermorosales.smarthome.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.guillermorosales.smarthome.R
import com.guillermorosales.smarthome.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViewModel()
    }

    private fun bindViewModel() {
        mainActivityViewModel.fetchLightState()
        mainActivityViewModel.lightState.observe(this, Observer<Boolean> { state ->
            switchLamp.isChecked = state!!
        })
        switchLamp.setOnCheckedChangeListener {_, checked -> mainActivityViewModel.setLightState(checked)}
    }
}
