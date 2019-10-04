package com.housseine.food.faas.view.activities

import android.os.Bundle
import android.widget.TextView
import com.housseine.food.faas.R
import com.housseine.food.faas.contract.DetailPlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.presenter.PlatDetailsPresenter
import kotlinx.android.synthetic.main.plat_detail.*
import kotlinx.android.synthetic.main.plat_detail.view.*

class DetailPlatActivity : BaseActivity(), DetailPlatContract.view {

    private var presenter: DetailPlatContract.Presenter? = null

    override fun showPlatData(plat: Plat) {
        tvPlatName?.text = plat.name
        tvPlatDesc?.text = plat.description
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plat_detail)

        presenter = PlatDetailsPresenter(this)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            bundle.apply {
                val plat = intent.getSerializableExtra("data")
                presenter?.onvViewCreated(plat as Plat)
            }
        }

    }
}