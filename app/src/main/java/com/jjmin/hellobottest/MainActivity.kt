package com.jjmin.hellobottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jjmin.hellobottest.adapter.ListAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjmin.hellobottest.model.IssueImgListModel
import com.jjmin.hellobottest.model.IssueListTextModel
import com.jjmin.hellobottest.model.ModelImpl
import com.jjmin.hellobottest.model.remote.IssueRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity() : AppCompatActivity() {

    var issueList = MutableLiveData<ArrayList<ModelImpl>>()

    private val repository : IssueRepository by inject{ parametersOf(this) }

    lateinit var adapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        issueList.value = arrayListOf()
        issueRecylcer.layoutManager = LinearLayoutManager(this)

        adapter = ListAdapter()

        issueRecylcer.adapter = adapter

        getIssueItem()
    }

    fun getIssueItem(){
        repository.getIssue()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                it.forEach {
                    var data = "${it.number} : ${it.title}"
                    Log.e("text",data)
                    issueList.value!!.add(IssueListTextModel(data))
                }
                issueList.value!!.add(4,IssueImgListModel("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png"))
                adapter.submitList(issueList.value)

            }) { e ->
                Log.e("error", e.message)
            }
    }
}
