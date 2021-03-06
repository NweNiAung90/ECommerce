package com.padcmyanmar.padc7.nna.ecommerce_assignment.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO

class CategoryResponse (

    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("apiVersion") val apiVersion: String,
    @SerializedName("page") val page: String,
    @SerializedName("categoryList") val categoryList: MutableList<CategoryVO>
) {


}