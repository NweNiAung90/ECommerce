package com.padcmyanmar.padc7.nna.ecommerce_assignment.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc7.nna.ecommerce_assignment.R
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductItemDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders.BaseViewHolder
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders.ProductViewHolder

/*
class ProductAdapter() : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onBindViewHolder(p0: ProductViewHolder, p1: Int) {
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
        var mLayoutInflater = LayoutInflater.from(p0.context)
        val productItemView = mLayoutInflater.inflate(R.layout.view_item_product, p0, false)
        return ProductViewHolder(productItemView)
    }
}*/
class ProductAdapter(context: Context,
                  private val mProductItemDelegate: ProductItemDelegate) : BaseRecyclerAdapter<ProductViewHolder, ProductVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productItemView = mLayoutInflator.inflate(R.layout.view_item_product, parent, false)
        return ProductViewHolder(productItemView, mProductItemDelegate)
    }

  /*  override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ProductVO>, position: Int) {

    }
*/
}