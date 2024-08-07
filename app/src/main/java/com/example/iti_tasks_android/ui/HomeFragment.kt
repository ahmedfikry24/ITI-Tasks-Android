package com.example.iti_tasks_android.ui

import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.fragment.findNavController
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.utils.SharedPrefManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class HomeFragment : Fragment() {
    private lateinit var phoneEditText: TextInputLayout
    private lateinit var messageEditText: TextInputLayout
    private lateinit var button: AppCompatButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneEditText = view.findViewById(R.id.phone_edit_text)
        messageEditText = view.findViewById(R.id.message_edit_text)
        phoneEditText.editText?.inputType = InputType.TYPE_CLASS_NUMBER
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            SharedPrefManager.phone = phoneEditText.editText?.text.toString().toInt()
            SharedPrefManager.message = messageEditText.editText?.text.toString()
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGalleryFragment())
        }
    }
}