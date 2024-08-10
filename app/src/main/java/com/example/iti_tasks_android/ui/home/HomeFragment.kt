package com.example.iti_tasks_android.ui.home

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.data.local.RoomManager
import com.example.iti_tasks_android.data.remote.RetrofitManager
import com.example.iti_tasks_android.data.repository.RepositoryImpl
import com.example.iti_tasks_android.data.source.LocalDataSourceImpl
import com.example.iti_tasks_android.data.source.RemoteDateSourceImpl
import com.example.iti_tasks_android.ui.home.view_model.HomeViewModel
import com.example.iti_tasks_android.ui.home.view_model.HomeViewModelFactory
import com.example.iti_tasks_android.utils.SharedPrefManager
import com.google.android.material.textfield.TextInputLayout

class HomeFragment : Fragment() {
    private lateinit var phoneEditText: TextInputLayout
    private lateinit var messageEditText: TextInputLayout
    private lateinit var button: AppCompatButton
    private val roomManager by lazy { RoomManager.getInit(requireContext()) }
    private val localDataSource by lazy { LocalDataSourceImpl(roomManager) }
    private val remoteDateSource by lazy { RemoteDateSourceImpl(RetrofitManager.service) }
    private val repository by lazy { RepositoryImpl(remoteDateSource, localDataSource) }
    private val viewModel: HomeViewModel by viewModels { HomeViewModelFactory(repository) }

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
            viewModel.addInfo(
                phone = phoneEditText.editText?.text.toString().toInt(),
                message = messageEditText.editText?.text.toString()
            )
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGalleryFragment())
        }
    }
}