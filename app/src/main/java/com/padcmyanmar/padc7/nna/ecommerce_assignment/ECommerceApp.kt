package com.padcmyanmar.padc7.nna.ecommerce_assignment

import android.app.Application
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.models.EcommerceAppModel

class ECommerceApp :Application(){
    companion object {
        const val TAG = "ECommerceApp"
    }

    override fun onCreate() {
        super.onCreate()
        EcommerceAppModel.initDataBase(applicationContext)
    }
}