package com.jjmin.hellobottest.remote

import com.jjmin.hellobottest.remote.model.IssueModel
import io.reactivex.Single

interface IssueRepository {
    fun getIssue() : Single<List<IssueModel>>
}