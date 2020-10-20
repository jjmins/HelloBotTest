package com.jjmin.hellobottest

import com.jjmin.hellobottest.remote.model.IssueModel
import io.reactivex.Single
import retrofit2.http.GET

interface API{

    @GET("issues")
    fun getIssue() : Single<List<IssueModel>>

}