package com.jjmin.hellobottest.model

data class IssueImgListModel(val image : String) : ModelImpl{
    override fun getType(): Int {
        return ItemType.IMG
    }

}