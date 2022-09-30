package com.mutualmobile.swiggy_clone.ui.screens.coupon

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ApplyCouponViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

}