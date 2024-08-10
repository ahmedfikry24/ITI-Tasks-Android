package com.example.iti_tasks_android.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.data.local.RoomManager
import com.example.iti_tasks_android.data.remote.RetrofitManager
import com.example.iti_tasks_android.data.repository.RepositoryImpl
import com.example.iti_tasks_android.data.source.LocalDataSourceImpl
import com.example.iti_tasks_android.data.source.RemoteDateSourceImpl
import com.example.iti_tasks_android.ui.gallery.view_model.GalleryViewModel
import com.example.iti_tasks_android.ui.gallery.view_model.GalleryViewModelFactory

class GalleryFragment : Fragment() {
    private lateinit var phoneText: TextView
    private lateinit var messageText: TextView
    private lateinit var getButton: AppCompatButton
    private lateinit var clearButton: AppCompatButton
    private val roomManager by lazy { RoomManager.getInit(requireContext()) }
    private val localDataSource by lazy { LocalDataSourceImpl(roomManager) }
    private val remoteDateSource by lazy { RemoteDateSourceImpl(RetrofitManager.service) }
    private val repository by lazy { RepositoryImpl(remoteDateSource, localDataSource) }
    private val viewModel: GalleryViewModel by viewModels { GalleryViewModelFactory(repository) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneText = view.findViewById(R.id.phone_value)
        messageText = view.findViewById(R.id.message_value)
        getButton = view.findViewById(R.id.button_get)
        clearButton = view.findViewById(R.id.button_clear)
        getButton.setOnClickListener { viewModel.getInfo() }
        clearButton.setOnClickListener { viewModel.deleteInfo() }
        viewModel.info.observe(viewLifecycleOwner) {
            phoneText.text = if (it.isNotEmpty()) it.first().phone.toString() else ""
            messageText.text = if (it.isNotEmpty()) it.first().message else ""
        }
    }
}