package com.housseine.food.faas.interactor

import com.housseine.food.faas.contract.PlatContract
import org.jetbrains.annotations.Contract
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit


class PlatInteractor:PlatContract.Interactor {
    var url = "http://192.168.42.104:8084/getallplats"
    var client = OkHttpClient.Builder().connectTimeout(7,TimeUnit.SECONDS).build()

    override fun loadPlatList(): String? {
       return getHttpRequest(url)
    }
    fun getHttpRequest(url: String): String? {
        var request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response -> return response.body?.string() }

    }



}