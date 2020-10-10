package com.jjmin.hellobottest.model

import com.jjmin.hellobottest.model.ItemType
import com.jjmin.hellobottest.model.ModelImpl

data class IssueListTextModel(val number : String,val title : String,val body : String) : ModelImpl {
    override fun getType(): Int {
        return ItemType.TEXT
    }
}