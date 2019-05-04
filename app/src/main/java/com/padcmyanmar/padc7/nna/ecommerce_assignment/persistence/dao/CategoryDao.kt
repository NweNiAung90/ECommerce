package com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryVO:  MutableList<CategoryVO>): LongArray

    @Query("SELECT * FROM category")
    fun getAllCategory(): MutableList<CategoryVO>

    @Query("SELECT * FROM category WHERE category_id = :id")
    fun getCategoryByID(id: Int): CategoryVO
}