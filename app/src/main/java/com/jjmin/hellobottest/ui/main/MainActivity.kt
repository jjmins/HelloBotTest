package com.jjmin.hellobottest.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjmin.hellobottest.ui.detail.DetailActivity
import com.jjmin.hellobottest.R
import com.jjmin.hellobottest.adapter.ListAdapter
import com.jjmin.hellobottest.remote.model.IssueImgListModel
import com.jjmin.hellobottest.remote.model.IssueTextListModel
import com.jjmin.hellobottest.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity() , MainContract.View{

    private val presenter : MainPresenter by inject{ parametersOf(this) }

    override var initLayoutResourse: Int = R.layout.activity_main
    lateinit var adapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.loadIssue()

        presenter.issueList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun settingRecyclerView() {
        issueRecylcer.layoutManager = LinearLayoutManager(this)

        adapter = ListAdapter { it ->
            when (it) {
                is IssueTextListModel -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("issueInfo", it)
                    startActivity(intent)
                }

                is IssueImgListModel -> {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://thingsflow.com/ko/home/"))
                    startActivity(browserIntent)
                }
            }
        }

        issueRecylcer.adapter = adapter
    }
}
