package com.example.contactapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.R
import com.example.contactapp.adapter.ContactAdapter
import com.example.contactapp.databinding.FragmentContactListBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.utils.OnItemClickListener
import com.example.contactapp.viewmodel.ContactViewModel

class ContactList : Fragment() {
    var contactList:List<Contact> = ArrayList<Contact>()
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentContactListBinding.inflate(inflater, container, false)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        val recyclerView = binding.rvContactList
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = ContactAdapter(contactList, object:OnItemClickListener{
            override fun OnItemClick(contact: Contact) {
                val action = ContactListDirections.actionContactListToProfile(contact)
                findNavController().navigate(action)
            }

        }, contactViewModel)

        recyclerView.adapter = adapter

        contactViewModel.getAllContact().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.contactList = it
                adapter.notifyDataSetChanged()
            }
        })

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_contactList_to_addContact)
        }

        return binding.root
    }

}