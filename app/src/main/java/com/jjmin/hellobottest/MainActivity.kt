package com.jjmin.hellobottest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjmin.hellobottest.adapter.ListAdapter
import com.jjmin.hellobottest.remote.model.IssueImgListModel
import com.jjmin.hellobottest.remote.model.IssueTextListModel
import com.jjmin.hellobottest.remote.model.ListModel
import com.jjmin.hellobottest.remote.IssueRepository
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

        issueList.observe(this, Observer {
            adapter.submitList(it)
        })

    }

    fun getIssueItem(){

        var list : ArrayList<ListModel> = arrayListOf()

        repository.getIssue()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                it.forEach { it ->
                    list.add(
                        IssueTextListModel(
                            "#${it.number}",
                            it.title,
                            it.body,
                            it.user!!.login,
                            it.user!!.profile
                        )
                    )
                }
                list.add(
                    4,
                    IssueImgListModel("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png")
                )

                issueList.value = list

            }) { e ->
                Log.e("error", e.message)
            }
    }
}
