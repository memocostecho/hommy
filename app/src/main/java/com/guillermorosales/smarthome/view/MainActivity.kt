package com.guillermorosales.smarthome.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.guillermorosales.smarthome.R
import com.guillermorosales.smarthome.viewmodel.MainViewModel
import com.jakewharton.rxbinding2.widget.RxCompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViewModel()
        lifecycle.addObserver(mainActivityViewModel)
    }

    private fun bindViewModel() {
        mainActivityViewModel.fetchLightState()
        mainActivityViewModel.lightState.observe(this, Observer<Boolean> { state ->
            switchLamp.isChecked = state!!
        })

        RxCompoundButton.checkedChanges(switchLamp).subscribe {
            mainActivityViewModel.setLightState(it)
        }
    }
}
