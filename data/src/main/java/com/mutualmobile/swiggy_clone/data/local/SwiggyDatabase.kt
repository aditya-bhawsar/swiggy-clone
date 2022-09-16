package com.mutualmobile.swiggy_clone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mutualmobile.swiggy_clone.data.local.dao.CartDao
import com.mutualmobile.swiggy_clone.data.local.model.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class SwiggyDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
