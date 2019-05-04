package com.padcmyanmar.padc7.nna.ecommerce_assignment.delegates

interface BaseDelegate<T> {

    fun onSuccess(data:T)

    fun onFail(error:String)
}