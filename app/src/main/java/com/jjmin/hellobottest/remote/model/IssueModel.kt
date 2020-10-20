package com.jjmin.hellobottest.remote.model

import com.google.gson.annotations.SerializedName

class IssueModel(){
    @SerializedName("title")
    lateinit var title : String
    @SerializedName("number")
    lateinit var number : String
    @SerializedName("body")
    lateinit var body : String
    @SerializedName("user")
    lateinit var user : User
}