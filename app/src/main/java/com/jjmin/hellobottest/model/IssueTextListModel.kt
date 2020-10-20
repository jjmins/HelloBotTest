package com.jjmin.hellobottest.model

data class IssueListTextModel(val number : String,val title : String,val body : String) : ListModel {
    override fun getType(): Int {
        return ItemType.TEXT.ordinal
    }
}