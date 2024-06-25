package com.example.apphub.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.apphub.R
import com.example.apphub.core.CustomInterface
import com.example.apphub.databinding.FragmentHomeBinding
import com.example.apphub.ui.adapter.home.HomeCategoryAdapter
import com.example.apphub.ui.adapter.home.StaggeredGridItemDecoration
import com.example.apphub.home.model.HomeCategoryDevType
import com.example.apphub.util.Constant

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init() {
        val categoryAdapter= HomeCategoryAdapter(requireContext(), Constant.homeCategoryList)

        binding.categoryRv.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.categoryRv.addItemDecoration(StaggeredGridItemDecoration(spacing = 25, spanCount = 2))
        binding.categoryRv.adapter=categoryAdapter
        categoryAdapter.setOnItemClick(onItemClick = object : CustomInterface.CustomInterface{
            override fun onItemClick(position: Int, view: View, data: Any?) {
                var type=data as HomeCategoryDevType?
                type?.let {
                    val extra= FragmentNavigatorExtras(view to "shared_image")
                    val bundle=Bundle()
                    bundle.putParcelable("data",type)
                    findNavController().navigate(R.id.action_homeFragment_to_homeCategoryFragment,args = bundle, navigatorExtras = extra, navOptions = null)
                }
            }
        })
    }

}