package com.jjmin.hellobottest.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.model.IssueImgListModel
import com.jjmin.hellobottest.model.IssueTextListModel
import com.jjmin.hellobottest.model.ListModel


class IssueTextViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int,
    private val onClick: ((ListModel) -> Unit)
) : BaseViewHolder<ListModel>(context, parent, layout) {
    lateinit var issueText : TextView

    override fun View.onBind(item: ListModel) {
        item as IssueTextListModel

        issueText = itemView.findViewById(R.id.issueTv) as TextView

        issueText.text = "${item.number} : ${item.title}"

        itemView.setOnClickListener {
            onClick(item)
        }
    }
}

class IssueImageViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int,
    private val onClick: ((ListModel) -> Unit)
) : BaseViewHolder<ListModel>(context, parent, layout) {
    lateinit var issueImg : ImageView

    override fun View.onBind(item: ListModel) {

        item as IssueImgListModel

        issueImg = itemView.findViewById(R.id.issueImg) as ImageView

        Glide.with(context)
            .load(item.image)
            .into(issueImg)

        itemView.setOnClickListener {
            onClick(item)
        }

    }

}

