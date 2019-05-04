package com.padcmyanmar.padc7.nna.ecommerce_assignment.network

import com.google.gson.Gson
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.CategoryResponseDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductResponseDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.network.responses.CategoryResponse
import com.padcmyanmar.padc7.nna.ecommerce_assignment.network.responses.ProductResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object EcommerceDataAgent {

    private val mEcommerceApi: EcommerceApi

    fun loadCategory(accessToken: String, page: Int, delegate: CategoryResponseDelegate) {
        val categoryResponseCall = mEcommerceApi.loadCategory(page, accessToken)
        categoryResponseCall.enqueue(object : Callback<CategoryResponse> {
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                val categoryResponse: CategoryResponse? = response.body()
                if (categoryResponse != null
                    && categoryResponse.code == 200
                    && categoryResponse.categoryList.isNotEmpty()
                ) {
                    delegate.onSuccess(categoryResponse.categoryList)
                } else {
                    if (categoryResponse != null)
                        delegate.onFail(categoryResponse.message)
                    else
                        delegate.onFail("Empty Api")
                }

            }
        })
    }

    fun loadProduct(accessToken: String, page: Int, delegate: ProductResponseDelegate) {
        val productResponseCall = mEcommerceApi.loadProduct(page, accessToken)
        productResponseCall.enqueue(object : Callback<ProductResponse> {
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                val productResponse: ProductResponse? = response.body()
                if (productResponse != null
                    && productResponse.code == 200
                    && productResponse.productList.isNotEmpty()
                ) {
                    delegate.onSuccess(productResponse.productList)
                } else {
                    if (productResponse != null)
                        delegate.onFail(productResponse.message)
                    else
                        delegate.onFail("Empty Api")
                }

            }
        })
    }

    fun loadProductById(accessToken: String, page: Int, delegate: ProductResponseDelegate) {
        val productResponseCall = mEcommerceApi.loadProduct(page, accessToken)
        productResponseCall.enqueue(object : Callback<ProductResponse> {
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                val productResponse: ProductResponse? = response.body()
                if (productResponse != null
                    && productResponse.code == 200
                    && productResponse.productList.isNotEmpty()
                ) {
                    delegate.onSuccess(productResponse.productList)
                } else {
                    if (productResponse != null)
                        delegate.onFail(productResponse.message)
                    else
                        delegate.onFail("Empty Api")
                }

            }
        })
    }

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        mEcommerceApi = retrofit.create(EcommerceApi::class.java)
    }
}