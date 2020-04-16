package com.simplex.rapientrega.presentation.views.activities

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.data.api.entities.stores.UbicationEntity
import com.simplex.rapientrega.domain.interfaces.MainInterface
import com.simplex.rapientrega.domain.tools.*
import com.simplex.rapientrega.presentation.presenters.activities.MainPresenter
import com.simplex.rapientrega.presentation.views.fragments.*

private const val CODE_LOCATION = 1

class MainActivity :
    BaseActivity(),
    MainInterface.View,
    View.OnClickListener,
    LocationListener,
    CategoryFragment.OnFragmentInteractionListener,
    ProfileFragment.OnFragmentInteractionListener,
    MainFragment.OnFragmentInteractionListener,
    OrderFragment.OnFragmentInteractionListener,
    StoreFragment.OnFragmentInteractionListener,
    SubCategoryFragment.OnFragmentInteractionListener,
    ProductFragment.OnFragmentInteractionListener,
    ProductDetailFragment.OnFragmentInteractionListener {

    private lateinit var messagePermission: TextView
    private lateinit var count: TextView
    private lateinit var update: ImageView
    private lateinit var dialogLocation: AlertDialog
    private lateinit var dialogCity: AlertDialog

    private lateinit var shoppingCarts: List<ShoppingCartEntity>
    private lateinit var presenter: MainInterface.Presenter
    private lateinit var locationManager: LocationManager
    private lateinit var cities: List<String>
    private var isSearch: Boolean = true
    private lateinit var ubicationEntity: UbicationEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        presenter.initial()
    }

    override fun layout(): Int {
        return R.layout.activity_main
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivShoppingCart -> {
                presenter.goShoppingCartActivity()
            }
            R.id.ivBack -> onBackPressed()
            R.id.ivUpdate -> presenter.havePermissions()
        }
    }


    override fun initialElements() {
        count = findViewById(R.id.tvShoppingCart)
        messagePermission = findViewById(R.id.tvMessage)
        update = findViewById(R.id.ivUpdate)
        createDialogLocation()
        createDialogCity()
    }

    override fun initialObjects() {
        val shoppingCartsString = preferences.getString(SHOPPING_CART, null)
        shoppingCarts = toListShoppingCart(shoppingCartsString)
        val count: Int = shoppingCarts.map { it.count }.sum()
        this.count.text = "$count"
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        cities = resources.getStringArray(R.array.cities).toList()
        ubicationEntity = UbicationEntity()
    }

    override fun addListener() {
        update.setOnClickListener(this)
    }

    override fun havePermissions() {
        if (checkPermission()) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), CODE_LOCATION
            )
            return
        }
        if (!isLocationEnabled()) {
            presenter.showDialogLocation()
            return
        }
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 0, 0f, this
        )
    }

    private fun isLocationEnabled(): Boolean {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    override fun showMessageNotPermissions() {
        messagePermission.visibility = View.VISIBLE
    }

    override fun hideMessageNotPermissions() {
        messagePermission.visibility = View.GONE
    }

    override fun showDialogLocation() {
        dialogLocation.show()
    }

    override fun hideDialogLocation() {
        dialogLocation.hide()
    }

    override fun showDialogCity() {
        dialogCity.show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        when (requestCode) {
            CODE_LOCATION -> {
                when (grantResults[0]) {
                    0 -> {
                        presenter.havePermissions()
                        return
                    }
                }
            }
        }
        presenter.showMessageNotPermissions()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_LOCATION) {
            presenter.havePermissions()
        }
    }

    private fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    }

    override fun addFragment(id: Int, fragment: MainFragment) {
        supportFragmentManager.beginTransaction().add(id, fragment).commit()
    }

    override fun goShoppingCartActivity() {
        val intent = Intent(this, ShoppingCartActivity::class.java)
        intent.putExtra(HEAD, true)
        startActivity(intent)
    }

    private fun createDialogLocation() {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogTheme))
        builder.setTitle(getString(R.string.app_name))
            .setMessage(getString(R.string.active_the_location))
            .setPositiveButton(R.string.yes) { _, _ ->
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivityForResult(intent, CODE_LOCATION)
            }.setNegativeButton(R.string.no) { _, _ -> presenter.showMessageNotPermissions() }
        dialogLocation = builder.create()
    }

    private fun createDialogCity() {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogTheme))
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_city, null)
        val city: Spinner = view.findViewById(R.id.spCity)
        builder.setTitle(getString(R.string.app_name))
            .setPositiveButton(R.string.yes) { _, _ ->
                val cityString = cities[city.selectedItemPosition]
                val ubicationString = objectToString(ubicationEntity)
                createCity(cityString, ubicationString)
                presenter.verifyDataInitial(preferences)
            }
            .setNegativeButton(R.string.no) { _, _ -> presenter.showMessageNotPermissions() }
        builder.setView(view)
        dialogCity = builder.create()
        dialogCity.setCancelable(false)
    }

    private fun createCity(city: String, ubication: String) {
        val editor = preferences.edit()
        editor.putString(CITY_USER, city)
        editor.putString(UBICATION_INITIAL, ubication)
        editor.apply()
    }

    override fun onLocationChanged(location: Location?) {
        if (location == null) {
            presenter.showMessageNotPermissions()
            return
        }
        ubicationEntity.latitude = location.latitude
        ubicationEntity.longitude = location.longitude
        if (isSearch) {
            presenter.verifyDataInitial(preferences)
            isSearch = false
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }
}
