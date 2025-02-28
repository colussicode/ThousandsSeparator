package com.example.thousandsseparator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandsseparator.ui.theme.DarkPurple
import com.example.thousandsseparator.ui.theme.LightPurple

@Composable
fun ThousandsSeparator(
    title: String,
    selectedItem: String,
    values: List<String>,
    onSelect: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = title,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = LightPurple.copy(alpha = 0.08f),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(6.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            values.onEach { value ->
                Column(
                    modifier = Modifier.weight(1f)
                        .background(
                            color = if (selectedItem == value) Color.White else Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) { onSelect(value) },
                    horizontalAlignment = CenterHorizontally,
                ) {
                    Text(
                        text = value,
                        color = if (selectedItem == value) Color.Black else DarkPurple,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}