package com.jjmin.hellobottest

import com.jjmin.hellobottest.model.IssueModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface API{

    @GET("issues")
    fun getIssue() : Single<List<IssueModel>>

}