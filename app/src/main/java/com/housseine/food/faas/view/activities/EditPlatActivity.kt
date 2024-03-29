package com.housseine.food.faas.view.activities

import android.os.Bundle
import com.housseine.food.faas.R
import com.housseine.food.faas.contract.UpdatePlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.presenter.PlatUpdatePresenter
import kotlinx.android.synthetic.main.edit_plat.*

class EditPlatActivity : BaseActivity(), UpdatePlatContract.view {


    private var presenter: UpdatePlatContract.Presenter? = null
    override fun showPlatData(plat: Plat) {
        etName?.setText(plat.name)
        etId?.setText(plat.id.toString())
        etDescription?.setText(plat.description)
        etPrice?.setText(plat.price.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_plat)


        presenter = PlatUpdatePresenter(this)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            bundle.apply {
                val plat = intent.getSerializableExtra("data")
                presenter?.onvViewCreated(plat as Plat)
            }
        }

        addPlatButton.setOnClickListener {
            Thread {
                run {
                    presenter?.onSaveDetailButtonClicked(
                        Plat(
                            etId.text.toString().toInt(),
                            etName.text.toString(),
                            etPrice.text.toString().toDouble(),
                            etDescription.text.toString()
                        )

                    )
                }
            }.start()
        }
    }


    override fun finishActivity() {
        finish()
    }
}