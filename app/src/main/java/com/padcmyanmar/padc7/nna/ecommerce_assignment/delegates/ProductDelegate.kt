package com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates

import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO

interface ProductDelegate {
    fun onSuccessProduct(data: MutableList<ProductVO>)

    fun onFail(error:String)
}