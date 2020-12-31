package com.mercedes.rahul.mercedesdemo.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Toast
import com.mercedes.rahul.mercedesdemo.R
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle
import com.mercedes.rahul.mercedesdemo.viewmodel.AddVehicleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.jvm.java

class AddVehicleActivity : AppCompatActivity() {

    private var vehicleNameEditText: EditText? = null
    private var vehicleTypeEditText: EditText? = null
    private var launchYearEditText: EditText? = null

    private var addVehicleViewModel:AddVehicleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        vehicleNameEditText = findViewById(R.id.vehicleName)
        vehicleTypeEditText = findViewById(R.id.vehicleType)
        launchYearEditText = findViewById(R.id.launchYear)

        addVehicleViewModel = ViewModelProviders.of(this).get(AddVehicleViewModel::class.java)

        fab.setOnClickListener {
            if (vehicleNameEditText!!.text == null || vehicleTypeEditText!!.text == null || launchYearEditText!!.text == null) {
                Toast.makeText(this, "No Vehicle Added!", Toast.LENGTH_SHORT).show()
            } else {
                addVehicleViewModel!!.addVehicle(Vehicle(
                        vehicleNameEditText!!.text.toString(),
                        vehicleTypeEditText!!.text.toString(),
                        launchYearEditText!!.text.toString()
                ))
                finish()
            }
        }
    }
}