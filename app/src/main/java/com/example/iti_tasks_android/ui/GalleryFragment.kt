package com.example.iti_tasks_android.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.navArgs
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.utils.SharedPrefManager

class GalleryFragment : Fragment() {
    private lateinit var phoneText: TextView
    private lateinit var messageText: TextView
    private lateinit var getButton: AppCompatButton
    private lateinit var clearButton: AppCompatButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneText = view.findViewById(R.id.phone_value)
        messageText = view.findViewById(R.id.message_value)
        getButton = view.findViewById(R.id.button_get)
        clearButton = view.findViewById(R.id.button_clear)
        getButton.setOnClickListener {
            phoneText.text = SharedPrefManager.phone.toString()
            messageText.text = SharedPrefManager.message
        }
        clearButton.setOnClickListener {
            SharedPrefManager.clearSharedPref()
            phoneText.text = SharedPrefManager.phone.toString()
            messageText.text = SharedPrefManager.message
        }
    }
}