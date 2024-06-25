package com.example.apphub.ui.fragment.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.doOnPreDraw
import androidx.transition.TransitionInflater
import com.example.apphub.R
import com.example.apphub.databinding.FragmentHomeCategoryBinding
import com.example.apphub.home.model.HomeCategoryDevType

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
            val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelable("data", HomeCategoryDevType::class.java)
            } else {
                arguments?.getParcelable("data")
            }
            data?.categoryIcon?.let {
                binding.devIcon.setImageResource(it)
            }
            binding.devName.text = data?.name?:""
        }
    }

}