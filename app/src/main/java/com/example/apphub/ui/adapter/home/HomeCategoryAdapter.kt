package com.example.apphub.ui.adapter.home
import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apphub.core.CustomInterface
import com.example.apphub.databinding.DevelomentGridItemBinding
import com.example.apphub.home.model.HomeCategoryDevType

class HomeCategoryAdapter(private var activity: Context,private var categoryList:List<HomeCategoryDevType>):RecyclerView.Adapter<HomeCategoryAdapter.MyCategoryHolder>() {
    private lateinit var binding: DevelomentGridItemBinding

    private lateinit var onItemClick:CustomInterface.CustomInterface

    class MyCategoryHolder(var item:DevelomentGridItemBinding):RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryHolder {
        binding= DevelomentGridItemBinding.inflate(LayoutInflater.from(activity))
        return MyCategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyCategoryHolder, position: Int) {
        var item= categoryList[position]
        holder.item.devIcon.setImageResource(item.categoryIcon)
        holder.item.devName.text=item.name

        holder.item.root.setOnClickListener {
            onItemClick.onItemClick(position = position, data = item, view = holder.item.devIcon)
        }
    }

    fun setOnItemClick(onItemClick:CustomInterface.CustomInterface){
        this.onItemClick=onItemClick
    }
}

class StaggeredGridItemDecoration(private val spacing: Int,private val spanCount: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val layoutParams = view.layoutParams as RecyclerView.LayoutParams
        val spanIndex = layoutParams.viewLayoutPosition % spanCount

        outRect.top = spacing
        outRect.bottom = spacing

        if (spanIndex == 0) {
            outRect.left = spacing
            outRect.right = spacing / spanCount
        } else {
            outRect.left = spacing / spanCount
            outRect.right = spacing
        }
    }

}