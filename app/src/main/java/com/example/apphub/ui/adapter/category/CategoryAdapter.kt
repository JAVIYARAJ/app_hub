package com.example.apphub.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.apphub.CategoryModel
import com.example.apphub.databinding.CategoryCardLayoutBinding

class CategoryAdapter(private val categories:List<CategoryModel>, private val activity: AppCompatActivity):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(var item:CategoryCardLayoutBinding):RecyclerView.ViewHolder(item.root)

    private lateinit var binding:CategoryCardLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding= CategoryCardLayoutBinding.inflate(LayoutInflater.from(activity))

        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val category=categories[position]
        //holder.item.categoryImg.setImageResource(category.id)
        holder.item.categoryTitleTv.text=category.title
    }


}