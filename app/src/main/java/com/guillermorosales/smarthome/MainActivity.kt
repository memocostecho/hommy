package com.guillermorosales.smarthome

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxCompoundButton
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViewModel()
    }

    private fun bindViewModel() {
        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        model.getLightState().observe(this, Observer<Boolean> { state ->
            switch_lamp.isChecked = state!!
        })

        RxCompoundButton.checkedChanges(switch_lamp).subscribe {
            model.setLightState(it)
        }
    }
}
