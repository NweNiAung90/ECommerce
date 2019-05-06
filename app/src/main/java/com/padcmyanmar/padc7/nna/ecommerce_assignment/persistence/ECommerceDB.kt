package com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.CategoryVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos.ProductVO
import com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.dao.CategoryDao
import com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.dao.ProductDao
import com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.typeconverters.CategoryTypeConverter
import com.padcmyanmar.padc7.nna.ecommerce_assignment.persistence.typeconverters.ProductImageTypeConverter

@Database(entities = arrayOf(ProductVO::class, CategoryVO::class), version = 4, exportSchema = false)
@TypeConverters(ProductImageTypeConverter::class,CategoryTypeConverter::class)
abstract class ECommerceDB : RoomDatabase() {
    abstract fun ProductDao() : ProductDao
    abstract fun CategoryDao() : CategoryDao

    companion object {

        private val DB_NAME = "ECommerceApp.DB"
        private var INSTANCE: ECommerceDB? = null

        fun getDatabase(context: Context): ECommerceDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, ECommerceDB::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}