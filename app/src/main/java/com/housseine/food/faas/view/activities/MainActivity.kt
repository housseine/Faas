package com.housseine.food.faas.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.support.v7.widget.RecyclerView
import com.codility.introsilder.PrefManager
import com.housseine.food.faas.R
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.view.adapters.PlatsListAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val recyclerView: RecyclerView by lazy { rv_plats_list_activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShowSlider.setOnClickListener(View.OnClickListener {
            PrefManager(applicationContext).setLaunched(true)

            finish()
        })
    }

    override fun publishDataList(data: List<Plat>) {
        (recyclerView.adapter as PlatsListAdapter).updateData(data)
    }



}
