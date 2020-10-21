package com.jjmin.hellobottest.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IssueTextListModel(
    val number: String?,
    val title: String?,
    val body: String?,
    val user: String?,
    val profile: String?
) : ListModel, Parcelable {
    override fun getType(): Int {
        return ItemType.TEXT.ordinal
    }
}