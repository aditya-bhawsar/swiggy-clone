package com.mutualmobile.swiggy_clone.domain.di

import com.mutualmobile.swiggy_clone.domain.repo.CartRepository
import com.mutualmobile.swiggy_clone.domain.usecase.cart.DeleteCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.GetCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.InsertCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.UpdateCartUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideInsertCartItemUseCase(cartRepository: CartRepository) =
        InsertCartUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideUpdateCartUseCase(cartRepository: CartRepository) = UpdateCartUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideGetCartItemUseCase(cartRepository: CartRepository) = GetCartUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideDeleteCartItemUseCase(cartRepository: CartRepository) =
        DeleteCartUseCase(cartRepository)
}