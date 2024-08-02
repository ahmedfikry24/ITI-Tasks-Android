package com.example.iti_tasks_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StaticFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("lifecycle 1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("lifecycle 2", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        return inflater.inflate(R.layout.fragment_static, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.e("lifecycle 3", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    override fun onResume() {
        super.onResume()
        Log.e("lifecycle 4", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    override fun onPause() {
        super.onPause()
        Log.e("lifecycle 5", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    override fun onStop() {
        super.onStop()
        Log.e("lifecycle 6", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("lifecycle 7", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

}