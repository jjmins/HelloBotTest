package com.jjmin.hellobottest.remote.model

data class IssueImgListModel(var image : String?) : ListModel{
    override fun getType(): Int {
        return ItemType.IMG.ordinal
    }



}