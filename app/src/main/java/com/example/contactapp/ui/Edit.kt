package com.example.contactapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentEditBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.viewmodel.ContactViewModel


class Edit : Fragment() {
        var contact:Contact? = null
        val args: ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val binding = FragmentEditBinding.inflate(inflater, container, false)
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        contact = args.contact
        binding.contact = contact

        binding.updateButtonId.setOnClickListener {
            contactViewModel.updateContact(contact!!)
            this.findNavController().navigateUp()
        }

        return binding.root
    }

}