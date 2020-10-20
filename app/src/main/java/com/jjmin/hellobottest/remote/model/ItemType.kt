package com.jjmin.hellobottest.remote.model

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.adapter.BaseViewHolder
import com.jjmin.hellobottest.adapter.IssueImageViewHolder
import com.jjmin.hellobottest.adapter.IssueTextViewHolder


enum class ItemType{

    TEXT{
        override fun onCreateViewHolder(
            context: Context,
            parent: ViewGroup,
            onClick: ((ListModel) -> Unit)
        ): BaseViewHolder<ListModel> {
            Log.e("test", "Test")
            return IssueTextViewHolder(context, parent, R.layout.item_issue_text,onClick)
        }
    },

    IMG{
        override fun onCreateViewHolder(
            context: Context,
            parent: ViewGroup,
            onClick: ((ListModel) -> Unit)
        ): BaseViewHolder<ListModel> {
            return IssueImageViewHolder(context, parent,R.layout.item_issue_img,onClick)
        }
    };

    abstract fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        onClick: ((ListModel) -> Unit)
    ): BaseViewHolder<ListModel>
}