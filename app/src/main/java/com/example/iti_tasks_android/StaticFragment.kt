package com.example.iti_tasks_android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

const val TAG = "staticFragment"

class StaticFragment : Fragment() {

    override fun onAttach(context: Context) {
        Log.e(TAG, "onAttach:")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_static, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(TAG, "onViewCreated:")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.e(TAG, "onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.e(TAG, "onPause: ")
        super.onPause()
    }

    override fun onDestroyView() {
        Log.e(TAG, "onDestroyView:")
        super.onDestroyView()
    }

    override fun onStop() {
        Log.e(TAG, "onStop: ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e(TAG, "onDetach: ", )
        super.onDetach()
    }

}