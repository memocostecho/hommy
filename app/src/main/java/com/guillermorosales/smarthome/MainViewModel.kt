package com.guillermorosales.smarthome

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel() {
    private lateinit var lightState: MutableLiveData<Boolean>

    fun getLightState(): MutableLiveData<Boolean> {
        if (!::lightState.isInitialized) {
            lightState = MutableLiveData()
            FirebaseDatabase.getInstance().reference.child("lights").child("on").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    lightState.value = dataSnapshot.value as Boolean?
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
        }
        return lightState
    }

    fun setLightState(checked: Boolean) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference
        myRef.child("lights").child("on").setValue(checked)
    }
}