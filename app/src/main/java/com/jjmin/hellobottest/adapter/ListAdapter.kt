package com.jjmin.hellobottest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.model.ItemType
import com.jjmin.hellobottest.model.ItemType.IMG
import com.jjmin.hellobottest.model.ItemType.TEXT
import com.jjmin.hellobottest.model.ModelImpl

class ListAdapter() : ListAdapter<ModelImpl, BaseViewHolder<ModelImpl>>(itemCallback){

    override fun getItemId(position: Int): Long {
        return getItemId(position).hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ModelImpl> {
        return when (viewType) {
            TEXT -> {
                IssueTextViewHolder(parent.context, parent, R.layout.item_issue_text)
            }
            IMG -> {
                IssueImageViewHolder(parent.context, parent, R.layout.item_issue_img)
            }
            else -> {
                IssueTextViewHolder(parent.context, parent, R.layout.item_issue_text)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ModelImpl>, position: Int) {
        holder.onBind(getItem(position))

    }

    override fun submitList(list: List<ModelImpl?>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<ModelImpl>() {
            override fun areItemsTheSame(
                oldItemData: ModelImpl,
                newItemData: ModelImpl
            ): Boolean {
                return oldItemData.getType() == newItemData.getType()
            }

            override fun areContentsTheSame(
                oldItemData: ModelImpl,
                newItemData: ModelImpl
            ): Boolean {
                return oldItemData.equals(newItemData)
            }
        }
    }
}