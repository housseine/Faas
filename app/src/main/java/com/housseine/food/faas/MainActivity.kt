package com.housseine.food.faas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codility.introsilder.PrefManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShowSlider.setOnClickListener(View.OnClickListener {
            PrefManager(applicationContext).setLaunched(true)

            finish()
        })
    }
}
