package com.padcmyanmar.padc7.nna.ecommerce_assignment.network

import com.padcmyanmar.padc7.nna.ecommerce_assignment.network.responses.CategoryResponse
import com.padcmyanmar.padc7.nna.ecommerce_assignment.network.responses.ProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EcommerceApi {
    @FormUrlEncoded
    @POST("fun/getCategory.php")
    fun loadCategory(
        @Field("page") pageIndex: Int,
        @Field("access_token") accessToken: String) : Call<CategoryResponse>

    @FormUrlEncoded
    @POST("fun/getProducts.php")
    fun loadProduct(
        @Field("page") pageIndex: Int,
        @Field("access_token") accessToken: String) : Call<ProductResponse>
}