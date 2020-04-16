package com.simplex.rapientrega.domain.tools

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.simplex.rapientrega.presentation.views.activities.BaseApplication

private const val CODE_LOCATION = 1

class LocationDevice {

    init {
        locationManager = BaseApplication.getContext()
            .getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    companion object {
        private lateinit var locationManager: LocationManager
        private fun checkPermission(): Boolean {
            return ActivityCompat.checkSelfPermission(
                BaseApplication.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                BaseApplication.getContext(), Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        }

        fun havePermissions(activity: Activity) {
            if (checkPermission()) {
                ActivityCompat.requestPermissions(
                    activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), CODE_LOCATION
                )
                return
            }
        }

        private fun isLocationEnabled(): Boolean {
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        }
    }

}