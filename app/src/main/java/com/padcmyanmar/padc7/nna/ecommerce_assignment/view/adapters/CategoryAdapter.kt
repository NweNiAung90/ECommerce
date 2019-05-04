package com.padcmyanmar.padc7.nna.ecommerce_assignment.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc7.nna.ecommerce_assignment.R
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates.ProductItemDelegate
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders.BaseViewHolder
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders.CategoryViewHolder
import com.padcmyanmar.padc7.nna.ecommerce_assignment.view.holders.ProductViewHolder

/*
class CategoryAdapter() : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryViewHolder {
        var mLayoutInflater = LayoutInflater.from(p0.context)
        val categoryItemView = mLayoutInflater.inflate(R.layout.view_item_category, p0, false)
        return CategoryViewHolder(categoryItemView)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(p0: CategoryViewHolder, p1: Int) {
    }
}*/
class CategoryAdapter(context: Context) : BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItemView = mLayoutInflator.inflate(R.layout.view_item_category, parent, false)
        return CategoryViewHolder(categoryItemView)
    }

 /*   override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: BaseViewHolder<CategoryVO>, position: Int) {

    }*/

}
