package com.housseine.food.faas.view.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.housseine.food.faas.R
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.presenter.PlatPresenter
import com.housseine.food.faas.view.adapters.PlatsListAdapter
import kotlinx.android.synthetic.main.activity_list.*
import java.io.Serializable

class ListPlatActivity: BaseActivity(), PlatContract.view  {
    override fun navigateTo(plat: Plat?):Intent {
        val intent = Intent(this,DetailPlatActivity::class.java)
        intent.putExtra("data", plat as Serializable)
        startActivity(intent)
        return intent
    }

    private var platPresenter: PlatContract.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        rv_plats_list_activity_main.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_plats_list_activity_main!!.adapter=PlatsListAdapter({ plat -> platPresenter?.listItemClicked(plat)},null,this)
        platPresenter = PlatPresenter(this)
                Thread {
            run {
                platPresenter?.onViewCreated()
            }
        }.start()

    }

    override fun publishDataList(data: List<Plat>) {
        (rv_plats_list_activity_main?.adapter as PlatsListAdapter).updateData(data)
    }


}