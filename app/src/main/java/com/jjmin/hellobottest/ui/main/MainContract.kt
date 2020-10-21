package com.jjmin.hellobottest.ui.main

import com.jjmin.hellobottest.ui.base.BaseContract

interface MainContract {
    interface View : BaseContract.View{
        fun settingRecyclerView()
    }

    interface Presenter : BaseContract.Presenter{
        fun loadIssue()
    }
}