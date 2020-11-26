package com.example.contactapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactListItemBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.ui.ContactList
import com.example.contactapp.utils.OnItemClickListener
import com.example.contactapp.viewmodel.ContactViewModel

class ContactAdapter(var contactList: List<Contact>, val onItemClickListener: OnItemClickListener, val contactViewModel: ContactViewModel):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {



    class ContactViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact, onItemClickListener: OnItemClickListener) {
            binding.contact = contact
            binding.root.setOnClickListener {
                onItemClickListener.OnItemClick(contact)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactListItemBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var contact = contactList[position]
        holder.bind(contact, onItemClickListener)
    }

}