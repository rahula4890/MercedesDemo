package com.mercedes.rahul.mercedesdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle
import androidx.room.Delete
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface VehicleDao {
    @Insert (onConflict = REPLACE)
    fun insert(vehicle: Vehicle)

    @Query("DELETE FROM vehicles_table")
    fun deleteAllVehicles()

    @Query("SELECT * FROM vehicles_table ")
    fun getAllVehicles(): LiveData<List<Vehicle>>

    @Query("select * from vehicles_table where id = :id")
    fun getVehicleById(id: String): Vehicle

    @Delete
    fun deleteVehicle(vehicle: Vehicle)
}