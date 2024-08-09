package com.example.iti_tasks_android.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.data.RepositoryImpl
import com.example.iti_tasks_android.data.remote.RetrofitManager
import com.example.iti_tasks_android.data.source.RemoteDateSourceImpl
import com.example.iti_tasks_android.ui.products.view_model.ProductsEvents
import com.example.iti_tasks_android.ui.products.view_model.ProductsViewModel
import com.example.iti_tasks_android.ui.products.view_model.ProductsViewModelFactory


class ProductsFragment : Fragment() {
    private val remoteDateSource by lazy { RemoteDateSourceImpl(RetrofitManager.service) }
    private val repository by lazy { RepositoryImpl(remoteDateSource) }
    private val viewMode by viewModels<ProductsViewModel> { ProductsViewModelFactory(repository) }
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
        viewMode.events.observe(viewLifecycleOwner) { event ->
            when (event) {
                ProductsEvents.Idle -> Unit
                is ProductsEvents.NavigateToProductDetails -> {
                    val direction =
                        ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(
                            title = event.title,
                            description = event.description,
                            url = event.imageUrl
                        )
                    findNavController().navigate(direction)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewMode.events.postValue(ProductsEvents.Idle)
    }

    private fun initViews(view: View) {
        progressBar = view.findViewById(R.id.progress_bar)
        recycler = view.findViewById(R.id.recycler)
        adapter = ProductsAdapter(listOf())
        recycler.adapter = adapter
    }
}