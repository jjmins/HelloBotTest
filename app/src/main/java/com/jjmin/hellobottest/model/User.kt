package com.jjmin.hellobottest.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("login")
    lateinit var login : String
}