package com.example.apphub.animation

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apphub.R
import com.example.apphub.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding
    private lateinit var allDevTypes:ArrayList<LinearLayoutCompat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        allDevTypes= arrayListOf(binding.appDevBtn,binding.webDevBtn,binding.blockchainDevBtn)

        binding.appDevBtn.setOnClickListener {
            binding.continueBtn.alpha=1f
            binding.appDevBtn.setBackgroundResource(R.drawable.selected_card)
            var animation= AnimationUtils.loadAnimation(this, R.anim.btn_fade_in_anim)
            binding.continueBtn.startAnimation(animation)
        }

        binding.appDevBtn.setOnClickListener {
            binding.continueBtn.alpha=1f
            binding.appDevBtn.setBackgroundResource(R.drawable.selected_card)
            var animation= AnimationUtils.loadAnimation(this, R.anim.btn_fade_in_anim)
            binding.continueBtn.startAnimation(animation)
        }
    }
}