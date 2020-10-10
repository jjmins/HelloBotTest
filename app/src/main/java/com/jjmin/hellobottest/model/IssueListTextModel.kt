package com.jjmin.hellobottest.model

import com.jjmin.hellobottest.model.ItemType
import com.jjmin.hellobottest.model.ModelImpl

data class IssueListTextModel(val text : String) : ModelImpl {
    override fun getType(): Int {
        return ItemType.TEXT
    }
}