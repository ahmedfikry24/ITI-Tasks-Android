package com.example.iti_tasks_android.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.fragment.findNavController
import com.example.iti_tasks_android.R

class HomeFragment : Fragment() {
    private lateinit var editText: AppCompatEditText
    private lateinit var button: AppCompatButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText = view.findViewById(R.id.edit_text)
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToGalleryFragment(
                    editText.text.toString()
                )
            )
        }
    }
}