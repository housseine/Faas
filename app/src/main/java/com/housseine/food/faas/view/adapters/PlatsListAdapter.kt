package com.housseine.food.faas.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.housseine.food.faas.R
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.view.activities.ListPlatActivity
import kotlinx.android.synthetic.main.plat_row.view.*

class PlatsListAdapter(private var listener: (Plat?) -> Unit, private var dataList: List<Plat>?,private var listPlatActivity: ListPlatActivity) :
    RecyclerView.Adapter<PlatsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater= LayoutInflater.from(parent?.context)
        val cellForRow= layoutInflater.inflate(R.layout.plat_row,parent,false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount()= dataList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder?.tvTitle?.text=dataList?.let { it[position].name }
    holder?.itemView?.setOnClickListener{listener(dataList?.get(position))}

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? =itemView.tvPlatTitle

    }

    fun updateData(list: List<Plat>) {
        this.dataList = list
        Thread(Runnable {
            listPlatActivity.runOnUiThread(Runnable {
                this.notifyDataSetChanged()
            })
        }).start()
       }

}