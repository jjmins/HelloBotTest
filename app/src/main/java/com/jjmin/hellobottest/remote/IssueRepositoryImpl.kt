package com.jjmin.hellobottest.remote

import com.jjmin.hellobottest.API
import com.jjmin.hellobottest.remote.model.IssueModel
import io.reactivex.Single

class IssueRepositoryImpl(private var api : API) : IssueRepository{
    override fun getIssue(): Single<List<IssueModel>> {
        return api.getIssue().map { it }
    }
}