package com.housseine.food.faas.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.codility.introsilder.IntroActivity
import com.codility.introsilder.PrefManager
import com.housseine.food.faas.R
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {



    private val recyclerView: RecyclerView by lazy { rv_plats_list_activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btShowSlider.setOnClickListener(View.OnClickListener {
            PrefManager(applicationContext).setLaunched(true)
            val intent = Intent(applicationContext, IntroActivity::class.java)
            startActivity(intent)
            finish()
            val intentPlatListActivity= Intent(applicationContext,ListPlatActivity::class.java)
            startActivity(intentPlatListActivity)

        })
    }


}
