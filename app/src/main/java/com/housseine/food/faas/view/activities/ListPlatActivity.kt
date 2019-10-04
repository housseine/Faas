package com.housseine.food.faas.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.housseine.food.faas.R
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.presenter.PlatPresenter
import com.housseine.food.faas.view.adapters.PlatsListAdapter
import kotlinx.android.synthetic.main.activity_list.*
import java.io.Serializable

class ListPlatActivity : BaseActivity(), PlatContract.view {
    val instanceOfListPlatActivity = this

    companion object {
        lateinit var listPlatActivity: ListPlatActivity
    }

    private var platPresenter: PlatContract.Presenter? = null

    override fun navigateToEdition(plat: Plat?) {
        val intent = Intent(this, EditPlatActivity::class.java)
        intent.putExtra("data", plat as Serializable)
        startActivity(intent)
    }

    override fun navigateToDetails(plat: Plat?) {
        val intent = Intent(this, DetailPlatActivity::class.java)
        intent.putExtra("data", plat as Serializable)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        listPlatActivity = instanceOfListPlatActivity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        bindListWithData()
    }

    fun bindListWithData(){
        rv_plats_list_activity_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_plats_list_activity_main!!.adapter =
            PlatsListAdapter(
                { plat -> platPresenter?.onListItemClicked(plat) },
                { plat -> platPresenter?.onEditButtonClicked(plat) },
                null,
                this
            )
        platPresenter = PlatPresenter(this)
        Thread {
            run {
                platPresenter?.onViewCreated()
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        bindListWithData()
        (rv_plats_list_activity_main?.adapter as PlatsListAdapter).refreshDalaList()
    }

    override fun publishDataList(data: List<Plat>) {
        (rv_plats_list_activity_main?.adapter as PlatsListAdapter).updateData(data)
    }


}