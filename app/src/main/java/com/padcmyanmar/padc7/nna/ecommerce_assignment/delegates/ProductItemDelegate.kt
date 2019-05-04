package com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates

import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO

interface ProductItemDelegate {
    fun onTapProduct(product :ProductVO)
}