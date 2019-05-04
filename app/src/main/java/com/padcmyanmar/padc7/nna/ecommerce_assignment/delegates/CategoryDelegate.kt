package com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates

import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO

interface CategoryDelegate {
    fun onSuccessCategory(data: MutableList<CategoryVO>)

    fun onFail(error:String)
}