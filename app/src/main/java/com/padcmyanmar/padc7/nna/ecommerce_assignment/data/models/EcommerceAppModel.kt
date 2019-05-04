package com.padcmyanmar.padc7.nna.ecommerce_assignment.data.models

import android.content.Context
import android.util.Log
import com.padcmyanmar.padc7.nna.ecommerce_assignment.ECommerceApp
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.CategoryDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.CategoryResponseDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductResponseDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.network.EcommerceDataAgent
import com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.ECommerceDB
import com.padcmyanmar.padc7.nna.ecommerce_assignment.utils.AppConstants

object EcommerceAppModel : BaseModel() {
    private var mProductPage: Int = 1
    private var mCategoryPage: Int = 1
    //private var mProductData: HashMap<Int, ProductVO> = HashMap()

    private lateinit var mTheDB: ECommerceDB

    fun initDataBase(context: Context) {
        mTheDB = ECommerceDB.getDatabase(context)
    }

    fun loadCategory(delegate: CategoryDelegate) {
        EcommerceDataAgent.loadCategory(AppConstants.ACCESS_TOKEN,
            mCategoryPage,
            object : CategoryResponseDelegate {
                override fun onSuccess(data: MutableList<CategoryVO>) {
                    val insertedCategories = mTheDB.CategoryDao().insertCategory(data)
                    Log.d(ECommerceApp.TAG, "insertedCategories : ${insertedCategories.size}")
                    val categoriesList = mTheDB.CategoryDao().getAllCategory()
                    Log.d(ECommerceApp.TAG, "categoriesList : ${categoriesList.size}")
                    //delegate.onSuccessCategory(data)
                    delegate.onSuccessCategory(categoriesList)
                }

                override fun onFail(error: String) {
                    delegate.onFail(error)
                }

            })

        }

    fun loadProduct(delegate: ProductDelegate) {
        EcommerceDataAgent.loadProduct(AppConstants.ACCESS_TOKEN,
            mProductPage,
            object : ProductResponseDelegate {
                override fun onSuccess(data: MutableList<ProductVO>) {

                   /* //save to the repository
                    for(product: ProductVO in data){
                        mProductData[product.productID] = product
                    }*/
                    val insertedProducts = mTheDB.ProductDao().insertProduct(data)
                    Log.d(ECommerceApp.TAG, "insertedProducts : ${insertedProducts.size}")
                    val productList = mTheDB.ProductDao().getAllProduct()
                    Log.d(ECommerceApp.TAG, "categoriesList : ${productList.size}")
                    //delegate.onSuccessProduct(data)
                    delegate.onSuccessProduct(productList)
                }

                override fun onFail(error: String) {
                    delegate.onFail(error)
                }

            })
    }

    fun getProductByID(productId: Int): ProductVO? {
       /* val data = mProductData[productId]
        return mProductData[productId]*/
        return mTheDB.ProductDao().getProductByID(productId)
    }

}
