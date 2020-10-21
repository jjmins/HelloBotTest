package com.jjmin.hellobottest.remote.model

import com.google.gson.annotations.SerializedName

class IssueModel(){
    @SerializedName("title")
    var title : String? = null
    @SerializedName("number")
    var number : String? = null
    @SerializedName("body")
    var body : String? = null
    @SerializedName("user")
    var user : User? = null
}