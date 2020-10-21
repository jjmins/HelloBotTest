package com.jjmin.hellobottest.ui.detail

import com.jjmin.hellobottest.ui.base.BaseContract

interface DetailContract{

    interface View : BaseContract.View{
        fun settingIssue()
        fun getIssueData()
    }

    interface Presenter : BaseContract.Presenter{
        fun loadUI()
    }

}