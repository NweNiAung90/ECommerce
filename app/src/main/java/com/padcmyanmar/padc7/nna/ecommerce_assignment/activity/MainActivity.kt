package com.padcmyanmar.padc7.nna.ecommerce_assignment.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.padcmyanmar.padc7.nna.ecommerce_assignment.R
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.models.EcommerceAppModel
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.*
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.adapters.CategoryAdapter
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.adapters.ProductAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),ProductItemDelegate,ProductDelegate,CategoryDelegate {

    private val mCategoryAdapter : CategoryAdapter
    private val mProductAdapter: ProductAdapter

    init {
        mCategoryAdapter = CategoryAdapter(applicationContext)
        mProductAdapter = ProductAdapter(applicationContext,this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rvCategories.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        rvCategories.adapter = mCategoryAdapter

        rvProducts.layoutManager = GridLayoutManager(applicationContext,2)

        rvProducts.adapter = mProductAdapter

        EcommerceAppModel.loadProduct(this)
        EcommerceAppModel.loadCategory(this)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onTapProduct(product: ProductVO) {
        val intent = Intent(applicationContext,ProductDetailsActivity::class.java)
        intent.putExtra("productId", product!!.productID)
        startActivity(intent)
    }


    override fun onSuccessProduct(data: MutableList<ProductVO>) {
        mProductAdapter.setNewData(data)
    }

    override fun onSuccessCategory(data: MutableList<CategoryVO>) {
        mCategoryAdapter.setNewData(data)
    }

    override fun onFail(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()    }
}
