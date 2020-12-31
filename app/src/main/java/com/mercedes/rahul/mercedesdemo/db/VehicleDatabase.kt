package com.mercedes.rahul.mercedesdemo.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.mercedes.rahul.mercedesdemo.db.dao.VehicleDao
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle

@Database(entities = [Vehicle::class], version = 1)
abstract class VehicleDatabase : RoomDatabase() {

    abstract fun itemAndVehicleModel(): VehicleDao

    companion object {

        private var INSTANCE: VehicleDatabase? = null

        fun getDatabase(context: Context): VehicleDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, VehicleDatabase::class.java, "vehicle_database")
                        .build()
            }
            return INSTANCE as VehicleDatabase
        }
    }
}
