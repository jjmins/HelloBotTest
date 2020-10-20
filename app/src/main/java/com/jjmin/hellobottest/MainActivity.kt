package com.jjmin.hellobottest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjmin.hellobottest.adapter.ListAdapter
import com.jjmin.hellobottest.model.IssueImgListModel
import com.jjmin.hellobottest.model.IssueTextListModel
import com.jjmin.hellobottest.model.ListModel
import com.jjmin.hellobottest.model.remote.IssueRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    var issueList = MutableLiveData<ArrayList<ListModel>>()

    private val repository : IssueRepository by inject()

    lateinit var adapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        issueList.value = arrayListOf()
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

        getIssueItem()
    }

    fun getIssueItem(){
        repository.getIssue()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                it.forEach { it ->
                    issueList.value!!.add(
                        IssueTextListModel(
                            "#${it.number}",
                            it.title,
                            it.body,
                            it.user.login,
                            it.user.profile
                        )
                    )
                }
                issueList.value!!.add(
                    4,
                    IssueImgListModel("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png")
                )
                adapter.submitList(issueList.value)

            }) { e ->
                Log.e("error", e.message)
            }
    }
}
