package com.jjmin.hellobottest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.model.ItemType
import com.jjmin.hellobottest.model.ListModel

class ListAdapter(private val onClick: (ListModel) -> Unit) :
    ListAdapter<ListModel, BaseViewHolder<ListModel>>(itemCallback) {

    override fun getItemId(position: Int): Long {
        return getItemId(position).hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ListModel> {
        return ItemType.values()[viewType].onCreateViewHolder(
            parent.context,
            parent,
            onClick
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ListModel>, position: Int) {
        holder.onBind(getItem(position))

    }

    override fun submitList(list: List<ListModel?>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<ListModel>() {
            override fun areItemsTheSame(
                oldItemData: ListModel,
                newItemData: ListModel
            ): Boolean {
                return oldItemData.getType() == newItemData.getType()
            }

            override fun areContentsTheSame(
                oldItemData: ListModel,
                newItemData: ListModel
            ): Boolean {
                return oldItemData.equals(newItemData)
            }
        }
    }
}