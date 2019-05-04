package com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductImageVO

class ProductImageTypeConverter {
    @TypeConverter
    fun fromJsontoList(productImageUrl: String): MutableList<ProductImageVO> {

        val listType = object : TypeToken<MutableList<ProductImageVO>>() {

        }.type
        return Gson().fromJson(productImageUrl,listType)
    }

    @TypeConverter
    fun fromListToJson(images: MutableList<ProductImageVO>): String {
        return Gson().toJson(images)
    }
}