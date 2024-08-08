package com.example.iti_tasks_android.ui.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.iti_tasks_android.R
import com.example.iti_tasks_android.ui.products.loadImage

class ProductDetailsFragment : Fragment() {
    private val args: ProductDetailsFragmentArgs by navArgs()
    private lateinit var image: AppCompatImageView
    private lateinit var title: TextView
    private lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.image)
        title = view.findViewById(R.id.title)
        description = view.findViewById(R.id.description)
        image.loadImage(args.url)
        title.text = args.title
        description.text = args.description
    }
}