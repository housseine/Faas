package com.housseine.food.faas.interactor

import android.util.Log
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.util.concurrent.TimeUnit
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody


class PlatInteractor : PlatContract.Interactor {
    var urlPlat = "http://192.168.42.104:8084"
    var client = OkHttpClient.Builder().connectTimeout(7, TimeUnit.SECONDS).build()
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    override fun loadPlatList(): String? {
        return getHttpRequest(urlPlat+"/getallplats")
    }

    override fun patchPlat(plat: Plat?) {
        val jsonObject: JSONObject = JSONObject()
        jsonObject.put("id", plat?.id)
        jsonObject.put("name",plat?.name)
        jsonObject.put("description",plat?.description)
        jsonObject.put("price",plat?.price)

        patchHttpRequest(urlPlat, jsonObject)

    }

    private fun getHttpRequest(url: String): String? {
        var request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response -> return response.body?.string() }

    }

    private fun patchHttpRequest(url: String, parameters: JSONObject) {
        val body: RequestBody = parameters.toString().toRequestBody(mediaType)
        var request = Request.Builder()
            .url(url).patch(body)
            .build()

        val resp = client.newCall(request).execute()
        Log.e("info", resp.body?.string())
    }

}