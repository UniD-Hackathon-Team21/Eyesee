package com.yblee2001.eyesee.ui.postings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yblee2001.eyesee.databinding.FragmentPostingsBinding

class PostingsFragment : Fragment() {

    private lateinit var binding: FragmentPostingsBinding
    private lateinit var adapter: PostingsCategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildCategoriesRecyclerView()

    }

    private fun buildCategoriesRecyclerView() {
        adapter = PostingsCategoriesAdapter(requireContext())
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireActivity())
        }
    }

}
