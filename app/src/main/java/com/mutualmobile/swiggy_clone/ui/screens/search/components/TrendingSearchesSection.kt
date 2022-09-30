package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingSearchesSection(onClickCallback: (String) -> Unit) {
    Text(
        text = "Trending Searches",
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    )

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 4.dp
    ) {
        SuggestionChip(onClick = { onClickCallback("Cake") }, label = { Text(text = "Cake") }, shape = CircleShape, icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = ""
            )
        }, colors = SuggestionChipDefaults.suggestionChipColors(iconContentColor = Color.LightGray, labelColor = Color.Gray), border = SuggestionChipDefaults.suggestionChipBorder(borderWidth = .5.dp, borderColor = Color.DarkGray))
        SuggestionChip(onClick = { onClickCallback("Sabudana Khichdi") }, label = { Text(text = "Sabudana Khichdi") }, shape = CircleShape, icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = ""
            )
        }, colors = SuggestionChipDefaults.suggestionChipColors(iconContentColor = Color.LightGray, labelColor = Color.Gray), border = SuggestionChipDefaults.suggestionChipBorder(borderWidth = .5.dp, borderColor = Color.DarkGray))
        SuggestionChip(onClick = { onClickCallback("South indian") }, label = { Text(text = "South indian") }, shape = CircleShape, icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = ""
            )
        }, colors = SuggestionChipDefaults.suggestionChipColors(iconContentColor = Color.LightGray, labelColor = Color.Gray), border = SuggestionChipDefaults.suggestionChipBorder(borderWidth = .5.dp, borderColor = Color.DarkGray))
        SuggestionChip(onClick = { onClickCallback("Pastry") }, label = { Text(text = "Pastry") }, shape = CircleShape, icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = ""
            )
        }, colors = SuggestionChipDefaults.suggestionChipColors(iconContentColor = Color.LightGray, labelColor = Color.Gray), border = SuggestionChipDefaults.suggestionChipBorder(borderWidth = .5.dp, borderColor = Color.DarkGray))
        SuggestionChip(onClick = { onClickCallback("Dosa") }, label = { Text(text = "Dosa") }, shape = CircleShape, icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = ""
            )
        }, colors = SuggestionChipDefaults.suggestionChipColors(iconContentColor = Color.LightGray, labelColor = Color.Gray), border = SuggestionChipDefaults.suggestionChipBorder(borderWidth = .5.dp, borderColor = Color.DarkGray))
    }

}
