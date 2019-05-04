package com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.view_item_product.view.*

class ProductViewHolder (itemView: View,
                         private val mDelegate: ProductItemDelegate) :  BaseViewHolder<ProductVO>(itemView) {
    override fun setData(data: ProductVO) {
        mData = data
        itemView.tvProductDetailsName.text =  data.productName
        itemView.tvProductPrice.text = data.price
        Glide.with(itemView.context)
            .load(data.productImageUrl[0].imageUrl)
            .into(itemView.ivProduct)


    }
    override fun onClick(v: View?) {
        mDelegate.onTapProduct(mData!!)
    }


}