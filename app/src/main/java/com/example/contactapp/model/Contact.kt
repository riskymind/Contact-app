package com.example.contactapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "contact_table")
@Parcelize
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var phone: String?,
    var address: String?
): Parcelable