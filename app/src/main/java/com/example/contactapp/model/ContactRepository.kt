package com.example.contactapp.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.contactapp.utils.CoroutineContactSingleton

class ContactRepository(application: Application) {
    private var contactDao: ContactDao
    private var allContact: LiveData<List<Contact>>

    init {
        var database:ContactDatabase = ContactDatabase.getInstance(application.applicationContext)
        contactDao = database.contactDao()
        allContact = contactDao.getAllContact()
    }

    fun getAllContact():LiveData<List<Contact>> {
        return allContact
    }

    fun insertContact(contact: Contact, application: Application) {
        CoroutineContactSingleton.getInstance(application).insertContact(contactDao, contact)
    }

    fun deleteContact(contact: Contact, application: Application) {
        CoroutineContactSingleton.getInstance(application).deleteContact(contactDao, contact)
    }

    fun updateContact(contact: Contact, application: Application) {
        CoroutineContactSingleton.getInstance(application).updateContact(contactDao, contact)
    }
}