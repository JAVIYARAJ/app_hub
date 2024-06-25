package com.example.apphub.util

import com.example.apphub.R
import com.example.apphub.home.model.CategoryItem
import com.example.apphub.home.model.HomeCategoryDevType

class Constant {

    companion object {
        val homeCategoryList = listOf(
            HomeCategoryDevType(
                id = 1,
                name = "Animation",
                categoryIcon = R.drawable.ic_animation,
                items = arrayListOf(CategoryItem(id = 1, name = "Shared Animation"))
            ),
            HomeCategoryDevType(id = 2, name = "Clean Architecture", categoryIcon = R.drawable.ic_android),
            HomeCategoryDevType(id = 3, name = "Networking", categoryIcon = R.drawable.ic_networking),
            HomeCategoryDevType(id = 4, name = "Code Design", categoryIcon = R.drawable.ic_designing),
            HomeCategoryDevType(
                id = 5,
                name = "Android components",
                categoryIcon = R.drawable.ic_components,
                items = arrayListOf(CategoryItem(id = 51, name = "Activity", categoryIcon = R.drawable.ic_components))
            )
        )
    }

}