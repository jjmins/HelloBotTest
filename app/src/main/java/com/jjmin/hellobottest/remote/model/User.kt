package com.jjmin.hellobottest.remote.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("login")
    lateinit var login : String
    @SerializedName("avatar_url")
    lateinit var profile : String
}