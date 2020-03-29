package com.simplex.rapientrega.presentation.views.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ProgressBar
import android.widget.Spinner
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.PayEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartDataInterface
import com.simplex.rapientrega.domain.tools.SHOPPING_CART
import com.simplex.rapientrega.domain.tools.USER
import com.simplex.rapientrega.presentation.presenters.activities.ShoppingCartDataPresenter

class ShoppingCartDataActivity :
    BaseActivity(),
    ShoppingCartDataInterface.View,
    View.OnClickListener {

    private lateinit var presenter: ShoppingCartDataInterface.Presenter
    private lateinit var payEntity: PayEntity
    private lateinit var cities: List<String>
    private lateinit var shoppingCarts: ArrayList<ShoppingCartEntity>
    private lateinit var paymentKey: List<String>
    private lateinit var loginEntity: LoginEntity

    private lateinit var address: TextInputLayout
    private lateinit var city: Spinner
    private lateinit var payment: Spinner
    private lateinit var progressBar: ProgressBar
    private lateinit var dialogConfirmPay: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ShoppingCartDataPresenter(this)
        presenter.initial()
    }

    override fun layout(): Int {
        return R.layout.activity_shopping_cart_data
    }

    override fun initialElements() {
        address = findViewById(R.id.tilAddress)
        city = findViewById(R.id.spCity)
        payment = findViewById(R.id.spType)
        progressBar = findViewById(R.id.progress_circular)
        createDialogPay()
    }

    override fun initialObjects() {
        cities = resources.getStringArray(R.array.cities).toList()
        paymentKey = resources.getStringArray(R.array.types_cash_key).toList()
        shoppingCarts = intent.getSerializableExtra(SHOPPING_CART) as ArrayList<ShoppingCartEntity>
        val loginString = preferences.getString(USER, null)
        presenter.convertUser(loginString)
    }

    override fun getLoginEntity(loginEntity: LoginEntity) {
        this.loginEntity = loginEntity
    }

    private fun goMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun pay() {
        val editor = preferences.edit()
        editor.remove(SHOPPING_CART)
        editor.apply()
    }

    override fun showDialog() {
        dialogConfirmPay.show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showMessage(id: Int) {
        createToast(id)
    }

    override fun errorAddress(message: String?) {
        address.error = message
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> onBackPressed()
            R.id.btUbication -> {
            }
            R.id.btPay -> {
                val city = cities[this.city.selectedItemPosition]
                val paymentKey = paymentKey[payment.selectedItemPosition]
                presenter.buildPay(
                    city,
                    address.editText?.text.toString(),
                    shoppingCarts,
                    loginEntity.profile.id,
                    1.21232131,
                    1.2321321312,
                    paymentKey
                )
            }
        }
    }

    private fun createDialogPay() {
        val build = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogTheme))
        build.setTitle(getString(R.string.app_name))
            .setMessage(getString(R.string.you_sure_pay))
            .setNegativeButton(R.string.no, null)
            .setPositiveButton(R.string.yes) { _, _ ->
                run {
                    goMainActivity()
                    pay()
                }
            }
        dialogConfirmPay = build.create()
        dialogConfirmPay.setCancelable(false)
    }
}
