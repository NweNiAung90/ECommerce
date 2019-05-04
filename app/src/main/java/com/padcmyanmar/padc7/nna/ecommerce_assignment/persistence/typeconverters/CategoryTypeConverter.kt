package com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductImageVO

class CategoryTypeConverter {
    @TypeConverter
    fun fromJsontoList(category: String): MutableList<CategoryVO> {

        val listType = object : TypeToken<MutableList<CategoryVO>>() {

        }.type
        return Gson().fromJson(category,listType)
    }

    @TypeConverter
    fun fromListToJson(images: MutableList<CategoryVO>): String {
        return Gson().toJson(images)
    }
}