package com.example.contactapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("select * from contact_table order by id desc")
    fun getAllContact(): LiveData<List<Contact>>


}