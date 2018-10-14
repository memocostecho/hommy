package com.guillermorosales.smarthome.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel(private val database: FirebaseDatabase) : ViewModel() {

    val lightState: MutableLiveData<Boolean> = MutableLiveData()

    fun fetchLightState() {
        database.reference.child(LIGHTS).child(ON).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                lightState.value = dataSnapshot.value as Boolean?
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // NO-OP TODO: shall we handle this case?
            }
        })
    }

    fun setLightState(checked: Boolean) =
            database.reference.child(LIGHTS).child(ON).setValue(checked)

    companion object {
        const val LIGHTS = "lights"
        const val ON = "ON"
    }

}