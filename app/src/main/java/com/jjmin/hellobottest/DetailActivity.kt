package com.jjmin.hellobottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.jjmin.hellobottest.remote.model.IssueTextListModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var issueModel = intent.getParcelableExtra("issueInfo") as IssueTextListModel?

        supportActionBar!!.title = issueModel!!.number

        issueContentTv.text = issueModel.body

        issueUserTv.text = issueModel.user

        Glide.with(this)
            .load(issueModel.profile)
            .circleCrop()
            .into(issueProfileImg)
    }
}
