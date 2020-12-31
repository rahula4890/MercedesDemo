package com.mercedes.rahul.mercedesdemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercedes.rahul.mercedesdemo.R
import com.mercedes.rahul.mercedesdemo.db.entity.Vehicle

class VehicleAdapter(private var vehicleList: List<Vehicle>?, private val longClickListener: View.OnLongClickListener) : RecyclerView.Adapter<VehicleAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.vehicle_recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val vehicle = vehicleList!![position]
        holder.nameTextView.text = vehicle.model
        holder.typeTextView.text = vehicle.type
        holder.launchYearTextView.text = vehicle.yearOfRelease
        holder.itemView.tag = vehicle
        holder.itemView.setOnLongClickListener(longClickListener)
    }

    override fun getItemCount(): Int {
        return vehicleList!!.size
    }

    fun addItems(vehicleList: List<Vehicle>) {
        this.vehicleList = vehicleList
        notifyDataSetChanged()
    }

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal val nameTextView: TextView = view.findViewById(R.id.vehicleNameTextView)
        internal val typeTextView: TextView = view.findViewById(R.id.VehicleTypeTextView)
        internal val launchYearTextView: TextView = view.findViewById(R.id.VehicleLaunchTextView)
    }
}
