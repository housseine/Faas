package com.housseine.food.faas.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.housseine.food.faas.R
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.view.activities.ListPlatActivity
import kotlinx.android.synthetic.main.plat_row.view.*

class PlatsListAdapter(
    private var listener: (Plat?) -> Unit,
    private var editListener: (Plat?) -> Unit,
    private var deleteListener: (Plat?) -> Unit,
    private var dataList: List<Plat>?,
    private var listPlatActivity: ListPlatActivity
) :
    RecyclerView.Adapter<PlatsListAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.tvTitle?.text = dataList?.let { it[position].name }
        holder?.itemView?.setOnClickListener { listener(dataList?.get(position)) }
        holder?.editButton?.setOnClickListener { editListener(dataList?.get(position)) }
        holder?.deleteButton?.setOnClickListener{deleteListener(dataList?.get(position))}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.plat_row, parent, false)
        return ViewHolder(cellForRow)}



    override fun getItemCount() = dataList?.size ?: 0


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? = itemView.tvPlatTitle
        val editButton: Button? = itemView.editButton
        val deleteButton: Button?= itemView.deletePlatButton

    }

    fun updateData(list: List<Plat>) {
        this.dataList = list
        Thread(Runnable {
            listPlatActivity.runOnUiThread(Runnable {
                this.notifyDataSetChanged()
            })
        }).start()
    }

    fun refreshDalaList(){
                this.notifyDataSetChanged()
    }

}