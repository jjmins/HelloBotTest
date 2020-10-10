package com.jjmin.hellobottest.model

import com.google.gson.annotations.SerializedName

open class IssueModel(){
    @SerializedName("title")
    lateinit var title : String
    @SerializedName("number")
    lateinit var number : String
    @SerializedName("body")
    lateinit var body : String
}