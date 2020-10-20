package com.jjmin.hellobottest.model

import android.util.Log

data class IssueImgListModel(val image : String) : ListModel{
    override fun getType(): Int {
        return ItemType.IMG.ordinal
    }



}