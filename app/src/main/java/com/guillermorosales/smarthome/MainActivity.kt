package com.guillermorosales.smarthome

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switch_lamp.setOnCheckedChangeListener {_, checked -> doSomething(checked)}
    }

    private fun doSomething(checked: Boolean) {
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference

        myRef.child("lights").child("on").setValue(checked)


    }
}
