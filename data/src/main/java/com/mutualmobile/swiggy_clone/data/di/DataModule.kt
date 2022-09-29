package com.mutualmobile.swiggy_clone.data.di

import android.content.Context
import androidx.room.Room
import com.mutualmobile.swiggy_clone.data.local.SwiggyDatabase
import com.mutualmobile.swiggy_clone.data.local.dao.CartDao
import com.mutualmobile.swiggy_clone.data.local.repo.CartRepositoryImpl
import com.mutualmobile.swiggy_clone.domain.repo.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : SwiggyDatabase {
        return Room.databaseBuilder(context, SwiggyDatabase::class.java, "SwiggyDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCartDao(swiggyDatabase: SwiggyDatabase) : CartDao {
        return swiggyDatabase.cartDao()
    }

    @Provides
    @Singleton
    fun provideCartRepository(cartDao: CartDao): CartRepository = CartRepositoryImpl(cartDao)

}