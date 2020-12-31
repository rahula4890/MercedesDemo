package com.mercedes.rahul.mercedesdemo.viewmodel

import android.os.AsyncTask
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mercedes.rahul.mercedesdemo.db.VehicleDatabase
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle

class AddVehicleViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase: VehicleDatabase = VehicleDatabase.getDatabase(this.getApplication())

    fun addVehicle(vehicle: Vehicle) {
        AddAsyncTask(appDatabase).execute(vehicle)
    }

    private class AddAsyncTask internal constructor(private val db: VehicleDatabase) : AsyncTask<Vehicle, Void, Void>() {

        override fun doInBackground(vararg params: Vehicle): Void? {
            db.itemAndVehicleModel().insert(params[0])
            return null
        }
    }
}