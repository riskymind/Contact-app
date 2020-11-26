package com.example.contactapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentProfileBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.viewmodel.ContactViewModel

class Profile : Fragment() {

    var contactViewModel: ContactViewModel? = null
    var contact: Contact? = null

    val args: ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        contact = args.contact
        binding.contact = contact

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.edit) {
            val action = ProfileDirections.actionProfileToEdit(contact!!)
            findNavController().navigate(action)
        }

        if (id == R.id.delete) {
            val mAlertDialog = AlertDialog.Builder(context)
            mAlertDialog.setTitle("Delete contact")
            mAlertDialog.setMessage("Contact will be deleted permanently")
            mAlertDialog.setIcon(R.mipmap.ic_launcher)
            mAlertDialog.setPositiveButton("Delete") { dialog, id ->
                contactViewModel?.deleteContact(contact!!)
                Toast.makeText(context, "Contact Deleted", Toast.LENGTH_SHORT).show()
                this.findNavController().navigateUp()
            }

            mAlertDialog.setNegativeButton("Cancel") { dialog, id ->
                dialog.dismiss()
            }
            mAlertDialog.show()
        }


        return super.onOptionsItemSelected(item)
    }
}