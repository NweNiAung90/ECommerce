package com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productVO: MutableList<ProductVO>): LongArray

    @Query("SELECT * FROM products")
    fun getAllProduct(): MutableList<ProductVO>

    @Query("SELECT * FROM products WHERE product_id = :id")
    fun getProductByID(id: Int): ProductVO



}