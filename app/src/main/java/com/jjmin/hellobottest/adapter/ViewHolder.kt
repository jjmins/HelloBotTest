package com.jjmin.hellobottest.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.jjmin.hellobottest.DetailActivity
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.model.IssueImgListModel
import com.jjmin.hellobottest.model.IssueListTextModel
import com.jjmin.hellobottest.model.ModelImpl


class IssueTextViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int
) : BaseViewHolder<ModelImpl>(context, parent, layout) {
    lateinit var issueText : TextView

    override fun View.onBind(item: ModelImpl) {
        item as IssueListTextModel

        issueText = itemView.findViewById(R.id.issueTv) as TextView

        issueText.text = "${item.number} : ${item.title}"

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("issueNumber",item.number)
            intent.putExtra("body",item.body)
            itemView.context.startActivity(intent)

        }
    }
}

class IssueImageViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int
) : BaseViewHolder<ModelImpl>(context, parent, layout) {
    lateinit var issueImg : ImageView

    override fun View.onBind(item: ModelImpl) {

        item as IssueImgListModel

        issueImg = itemView.findViewById(R.id.issueImg) as ImageView

        Glide.with(context)
            .load(item.image)
            .into(issueImg)

        itemView.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://thingsflow.com/ko/home/"))
            itemView.context.startActivity(browserIntent)
        }

    }

}

