package com.mercedes.rahul.mercedesdemo.viewmodel

import android.os.AsyncTask
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mercedes.rahul.mercedesdemo.db.VehicleDatabase
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle
import androidx.lifecycle.LiveData

class VehicleViewModel(application: Application) : AndroidViewModel(application) {

    val itemAndVehicleList: LiveData<List<Vehicle>>

    private val vehicleDatabase: VehicleDatabase = VehicleDatabase.getDatabase(this.getApplication<Application>())

    init {
        itemAndVehicleList = vehicleDatabase.itemAndVehicleModel().getAllVehicles()
    }

    fun deleteVehicle(vehicle: Vehicle) {
        DeleteAsyncTask(vehicleDatabase).execute(vehicle)
    }

    private class DeleteAsyncTask internal constructor(private val db: VehicleDatabase) : AsyncTask<Vehicle, Void, Void>() {
        override fun doInBackground(vararg params: Vehicle): Void? {
            db.itemAndVehicleModel().deleteVehicle(params[0])
            return null
        }
    }
}
