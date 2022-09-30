package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    queryChangedCallback: (String) -> Unit,
    placeholderText: String,
    leadingComposable: @Composable () -> Unit,
    trailingComposable: @Composable () -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        value = query,
        placeholder = { Text(text = placeholderText, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Light)) },
        onValueChange = { queryChangedCallback(it) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
        ),
        leadingIcon = leadingComposable,
        trailingIcon = trailingComposable
    )
}
