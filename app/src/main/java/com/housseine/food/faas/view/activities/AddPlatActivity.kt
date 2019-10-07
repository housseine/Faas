package com.housseine.food.faas.view.activities

import android.os.Bundle
import com.housseine.food.faas.R
import com.housseine.food.faas.commons.Utils
import com.housseine.food.faas.contract.AddPlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.presenter.PlatAddPresenter
import com.housseine.food.faas.view.fragments.FragmentPlatForm
import kotlinx.android.synthetic.main.activity_add_plat.*
import kotlinx.android.synthetic.main.activity_add_plat.addPlatButton
import kotlinx.android.synthetic.main.edit_plat.*
import kotlinx.android.synthetic.main.fragment_palt.*

class AddPlatActivity : BaseActivity() ,AddPlatContract.view{
    var presenter: AddPlatContract.Presenter?=null


    override fun finishActivity() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter= PlatAddPresenter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plat)
        Utils.addFragment(FragmentPlatForm(),true,fragment_container.id,supportFragmentManager,"formPlat")

        addPlatButton.setOnClickListener {

            Thread {
                run {
                    presenter?.onSaveDetailButtonClicked(
                        Plat(
                            0,
                            fEtName.text.toString(),
                            fEtPrice.text.toString().toDouble(),
                            fEtDescription.text.toString()
                        )

                    )
                }
            }.start()
        }
    }


}