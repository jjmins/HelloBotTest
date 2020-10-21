package com.jjmin.hellobottest.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jjmin.hellobottest.remote.IssueRepository
import com.jjmin.hellobottest.remote.model.IssueImgListModel
import com.jjmin.hellobottest.remote.model.IssueTextListModel
import com.jjmin.hellobottest.remote.model.ListModel
import com.jjmin.hellobottest.ui.base.BaseContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    override val view: MainContract.View,
    private val repository : IssueRepository) : MainContract.Presenter{

    var issueList = MutableLiveData<ArrayList<ListModel>>()

    init {
        view.settingRecyclerView()
    }

    override fun loadIssue() {
        issueList.value = arrayListOf()

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
                            it.user.login,
                            it.user.profile
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