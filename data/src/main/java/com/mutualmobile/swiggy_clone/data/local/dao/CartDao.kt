package com.mutualmobile.swiggy_clone.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mutualmobile.swiggy_clone.data.local.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM CartItem")
    fun getCartItems(): Flow<List<CartItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(cartItem: CartItem)

    @Delete
    suspend fun deleteItem(cartItem: CartItem)

//    @Query("SELECT")
//    fun getCartTotal() : Flow<Int>
}