package com.liveattendanceapps.views.attendance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.liveattendanceapps.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AttendanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttendanceFragment : Fragment(), OnMapReadyCallback {

    private var mapsattendance:SupportMapFragment? = null
    private var map: GoogleMap? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_attendance, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupmaps()
    }

    private fun setupmaps() {
        mapsattendance = childFragmentManager.findFragmentById(R.id.map_attendance) as SupportMapFragment
        mapsattendance?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap
        //Coordinate Bisa di ganti sesuai tempat teman-teman masing-masing
        val sydney = LatLng(-6.5644769, 106.798278)
        map?.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in home")
        )
        map?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        map?.animateCamera(CameraUpdateFactory.zoomTo(20f))
    }
}

