package com.mutualmobile.swiggy_clone.common

import androidx.compose.foundation.lazy.LazyListState

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex> 0 || firstVisibleItemScrollOffset>0