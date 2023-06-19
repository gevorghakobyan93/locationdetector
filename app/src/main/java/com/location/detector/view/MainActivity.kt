package com.location.detector.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.location.detector.R
import com.location.detector.data.model.Location
import com.location.detector.databinding.ActivityMainBinding
import com.location.detector.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var map: GoogleMap
    private lateinit var location: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mapFragment: SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.view?.visibility = View.GONE
        mapFragment?.getMapAsync(this)

        binding.headerSearch.setOnEditorActionListener { _, _, _ ->
            viewModel.getLocation(binding.headerSearch.text.toString())
            false
        }

        viewModel.locationData.observe(this) {
            location = it
            binding.description.movementMethod = ScrollingMovementMethod()
            binding.description.text = location.toString()
            mapFragment?.view?.visibility = View.VISIBLE
            val latLng = LatLng(location.latitude, location.longitude)

            map.addMarker(MarkerOptions().position(latLng).title("Location"))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        }
        viewModel.errorData.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.exceptionData.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}