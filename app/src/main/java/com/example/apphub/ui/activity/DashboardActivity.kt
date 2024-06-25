package com.example.apphub.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apphub.ui.adapter.category.CategoryAdapter
import com.example.apphub.CategoryModel
import com.example.apphub.R
import com.example.apphub.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = arrayListOf(
            CategoryModel(id = 1, title = "Android", icon = R.drawable.ic_coding_icon1),
            CategoryModel(id = 2, title = "Flutter", icon = R.drawable.ic_coding_icon1),
            CategoryModel(id = 3, title = "Python", icon = R.drawable.ic_coding_icon1)
        )

        val adapter = CategoryAdapter(list, this)
        binding.categoryRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRv.adapter = adapter
    }

}