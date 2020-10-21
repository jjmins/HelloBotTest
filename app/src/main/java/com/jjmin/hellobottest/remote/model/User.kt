package com.jjmin.hellobottest.remote.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("login")
    var login : String? = null
    @SerializedName("avatar_url")
    var profile : String? = null
}