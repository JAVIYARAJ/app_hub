package com.example.apphub.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.transition.TransitionInflater
import com.example.apphub.R
import com.example.apphub.databinding.FragmentHomeCategoryBinding

class HomeCategoryFragment : Fragment() {

    private lateinit var binding: FragmentHomeCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition= TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition= TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeCategoryBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init() {
        if(requireArguments().containsKey("data")){
            Log.d("TAG", "custom: ${requireArguments().getString("data")}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.devIcon.apply {
            transitionName="shared_image"
            view.doOnPreDraw { startPostponedEnterTransition() }
        }*/
    }

}