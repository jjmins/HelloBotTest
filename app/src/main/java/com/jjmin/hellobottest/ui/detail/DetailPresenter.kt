package com.jjmin.hellobottest.ui.detail


class DetailPresenter(override val view: DetailContract.View) : DetailContract.Presenter{

    override fun loadUI() {
        view.getIssueData()
        view.settingIssue()
    }

}