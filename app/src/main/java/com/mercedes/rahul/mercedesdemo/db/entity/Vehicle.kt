package com.mercedes.rahul.mercedesdemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles_table")
data class Vehicle(

        var model: String,

        var type: String,

        var yearOfRelease: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}