package com.padcmyanmar.padc7.nna.ecommerce_assignment.activity

import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.padcmyanmar.padc7.nna.ecommerce_assignment.R
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.models.EcommerceAppModel
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.adapters.ProductAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : BaseActivity(),ProductDelegate {

    private lateinit var mProductAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_grey_24dp)

        val productId: Int = intent.getIntExtra("productId", -1)
        Log.d("ProductDetailsActivity ", "Product ID : " + productId.toString())
        val product = EcommerceAppModel.getProductByID(productId)
        bindData(product!!)
    }
    private fun bindData(product: ProductVO) {
        Glide.with(applicationContext)
            .load(product.productImageUrl[0].imageUrl)
            .into(ivProductDetails)

        tvProductDetailsName.text =  product.productName
        tvProductPrice.text = product.price
        tvProductDescription.text = product.desc



    }
    override fun onSuccessProduct(data: MutableList<ProductVO>) {



    }

    override fun onFail(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}