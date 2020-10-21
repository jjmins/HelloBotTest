package com.jjmin.hellobottest.ui.base

import android.content.Context

interface BaseContract{
    interface View{
        fun toastMessage(text : String)
    }

    interface Presenter{
        val view : View
    }
}