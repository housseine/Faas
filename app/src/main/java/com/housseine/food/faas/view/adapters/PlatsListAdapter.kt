package com.housseine.food.faas.view.adapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.housseine.food.faas.entity.Plat

class PlatsListAdapter(private var listener:(Plat?)->Unit, private var dataList: List<Plat>?): RecyclerView.Adapter<PlatsListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       // val tvId: TextView? =itemView.
    }

    fun updateData(list: List<Plat>) {

    }

}