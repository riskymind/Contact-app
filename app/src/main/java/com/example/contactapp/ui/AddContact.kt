package com.example.contactapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentAddContactBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.activity_main.*

class AddContact : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        binding.buttonSubmitId.setOnClickListener {
            var firstName = binding.editFirstNameId.text.toString()
            var lastName = binding.editLastNameId.text.toString()
            var email = binding.editEmailId.text.toString()
            var phone = binding.editPhoneId.text.toString()
            var address = binding.editAddressId.text.toString()

            var captureContact = Contact(0, firstName, lastName, email, phone, address)
            contactViewModel.insertContact(captureContact)
            Toast.makeText(context, "Saved!!", Toast.LENGTH_SHORT).show()

            this.findNavController().navigateUp()
        }


        return binding.root
    }

}