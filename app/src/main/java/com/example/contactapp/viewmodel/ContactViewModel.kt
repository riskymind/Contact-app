package com.example.contactapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.contactapp.model.Contact
import com.example.contactapp.model.ContactRepository

class ContactViewModel(application: Application): AndroidViewModel(application) {
    private var repository = ContactRepository(application)
    private var allContact = repository.getAllContact()

    fun insertContact(contact: Contact) {
        repository.insertContact(contact, getApplication())
    }

    fun getAllContact(): LiveData<List<Contact>> {
        return allContact
    }

    fun deleteContact(contact: Contact) {
        repository.deleteContact(contact, getApplication())
    }

    fun updateContact(contact: Contact) {
        repository.updateContact(contact, getApplication())
    }
}