package com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v4.widget.ImageViewCompat
import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import kotlinx.android.synthetic.main.view_item_category.view.*

class CategoryViewHolder(itemView: View) :  BaseViewHolder<CategoryVO>(itemView) {
    override fun setData(data: CategoryVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.icon)
            .into(itemView.ivCategory)

        itemView.tvCategoryName.text = data.catName

    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}