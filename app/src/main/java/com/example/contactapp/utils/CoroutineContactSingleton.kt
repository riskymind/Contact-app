package com.example.contactapp.utils

import android.app.Application
import com.example.contactapp.model.Contact
import com.example.contactapp.model.ContactDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineContactSingleton(application: Application) {

    companion object {
        @Volatile
        private var INSTANCE:CoroutineContactSingleton? = null

        fun getInstance(application: Application) =
            INSTANCE ?:CoroutineContactSingleton(application).also {
                INSTANCE = it
            }

    }

    fun insertContact(contactDao: ContactDao, contact: Contact) {
        CoroutineScope(Dispatchers.IO).launch {
            contactDao.insertContact(contact)
        }
    }

    fun deleteContact(contactDao: ContactDao, contact: Contact) {
        CoroutineScope(Dispatchers.IO).launch {
            contactDao.deleteContact(contact)
        }
    }

    fun updateContact(contactDao: ContactDao, contact: Contact) {
        CoroutineScope(Dispatchers.IO).launch {
            contactDao.updateContact(contact)
        }
    }
}