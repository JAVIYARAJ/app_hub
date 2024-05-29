package com.example.apphub.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class HomeCategoryDevType(
    var id:Int,
    var name:String,
    var categoryIcon:Int,
    var items:ArrayList<CategoryItem>?=null
):Parcelable

@Parcelize
data class CategoryItem(
    var id:Int,
    var name:String,
    var categoryIcon:Int?=null
):Parcelable