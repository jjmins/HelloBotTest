package com.jjmin.hellobottest.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.remote.model.IssueTextListModel
import com.jjmin.hellobottest.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DetailActivity : BaseActivity() , DetailContract.View {

    private val presenter : DetailPresenter by inject{ parametersOf(this) }

    override var initLayoutResourse: Int = R.layout.activity_detail
    var issueModel : IssueTextListModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadUI()
    }

    override fun settingIssue() {
        supportActionBar!!.title = issueModel!!.number
        issueContentTv.text = issueModel!!.body
        issueUserTv.text = issueModel!!.user

        Glide.with(this)
            .load(issueModel!!.profile)
            .circleCrop()
            .into(issueProfileImg)
    }

    override fun getIssueData() {
        issueModel = intent.getParcelableExtra("issueInfo") as IssueTextListModel
    }
}
