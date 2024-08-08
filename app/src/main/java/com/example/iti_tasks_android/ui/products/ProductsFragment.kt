package com.example.iti_tasks_android.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.ui.products.view_model.ProductsViewModel


class ProductsFragment : Fragment() {
    private val viewMode: ProductsViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewMode.getProducts()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        viewMode.isLoading.observe(viewLifecycleOwner) {
            progressBar.isVisible = it
            recycler.isVisible = !it
        }
        viewMode.state.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }
    }


    private fun initViews(view: View) {
        progressBar = view.findViewById(R.id.progress_bar)
        recycler = view.findViewById(R.id.recycler)
        adapter = ProductsAdapter(listOf())
        adapter.onItemClick = object : ItemListener {
            override fun onClick(title: String, description: String, url: String) {
                val direction =  ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(
                    title = title,
                    description = description,
                    url = url
                )
               findNavController().navigate(direction)
            }
        }
        recycler.adapter = adapter
    }
}