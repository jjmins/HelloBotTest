package com.jjmin.hellobottest.model.remote

import com.jjmin.hellobottest.model.IssueModel
import io.reactivex.Single

interface IssueRepository {
    fun getIssue() : Single<List<IssueModel>>
}