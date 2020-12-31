package com.mercedes.rahul.mercedesdemo.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercedes.rahul.mercedesdemo.R
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle
import com.mercedes.rahul.mercedesdemo.viewmodel.VehicleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnLongClickListener {
    private var viewModel: VehicleViewModel? = null
    private var recyclerViewAdapter: VehicleAdapter? = null
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener { startActivity(Intent(this@MainActivity, AddVehicleActivity::class.java)) }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewAdapter = VehicleAdapter(ArrayList<Vehicle>(), this)
        setupRecyclerView()
        viewModel= ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(VehicleViewModel::class.java)
        viewModel!!.itemAndVehicleList.observe(this@MainActivity, Observer<List<Vehicle?>?> { vehicleList -> recyclerViewAdapter!!.addItems(vehicleList as List<Vehicle>) })
    }

    private fun setupRecyclerView() {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = recyclerViewAdapter
    }

    override fun onLongClick(v: View): Boolean {
        val vehicle: Vehicle = v.tag as Vehicle
        viewModel?.deleteVehicle(vehicle)
        return true
    }
}
