package com.hyperjar.philip.arnold.mainscreen.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hyperjar.philip.arnold.R
import com.hyperjar.philip.arnold.data.ItemData
import com.hyperjar.philip.arnold.data.ItemX
import com.hyperjar.philip.arnold.mainscreen.MainActivityInterface

class ListAdapter(val items: ItemData, val mainActivityInterface: MainActivityInterface): RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_item, parent, false), mainActivityInterface)
    }

    override fun getItemCount(): Int = items.transactionLog.items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.Bind(items.transactionLog.items.get(position), items.id)
    }

    class ItemViewHolder(view: View, mainActivityInterface: MainActivityInterface): RecyclerView.ViewHolder(view) {
        val title: TextView
        val value: TextView
        val status: TextView
        init {
            title = view.findViewById(R.id.title)
            value = view.findViewById(R.id.value)
            status = view.findViewById(R.id.status)
        }

        fun Bind(item: ItemX, me: String) {
            value.text = item.amount.totalAmount
            status.text = item.status
            if (item.financialSource.owner.id.equals(me)) {
                title.text = item.financialDestination.account.name
            } else {
                title.text = String.format("%s, %s", item.financialSource.owner.name, item.financialSource.account.name)
            }
        }
    }
}

/*
   £3,400.00
CAD 4,100.00


7,900Y
CAD 4.800.50

 */