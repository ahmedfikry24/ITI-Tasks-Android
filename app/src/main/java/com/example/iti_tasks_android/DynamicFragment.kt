package com.example.iti_tasks_android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val TAG_DYNAMIC = "dynamicFragment"

class DynamicFragment : Fragment() {

    override fun onAttach(context: Context) {
        Log.e(TAG_DYNAMIC, "onAttach: ")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG_DYNAMIC, "onCreate: ")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG_DYNAMIC, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(TAG_DYNAMIC, "onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.e(TAG_DYNAMIC, "onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG_DYNAMIC, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.e(TAG_DYNAMIC, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG_DYNAMIC, "onStop: ")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e(TAG_DYNAMIC, "onDestroyView: ")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e(TAG_DYNAMIC, "onDestroy: ")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e(TAG_DYNAMIC, "onDetach: ")
        super.onDetach()
    }

}