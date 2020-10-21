package com.jjmin.hellobottest.remote.model

data class IssueImgListModel(val image : String?) : ListModel{
    override fun getType(): Int {
        return ItemType.IMG.ordinal
    }



}