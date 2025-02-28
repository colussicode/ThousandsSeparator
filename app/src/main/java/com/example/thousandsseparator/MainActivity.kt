package com.example.thousandsseparator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thousandsseparator.ui.theme.ThousandsSeparatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            ThousandsSeparatorTheme {
                var selectedValue by remember { mutableStateOf(getThousandsValues().first()) }
                val valuesCollection by remember { mutableStateOf(getThousandsValues()) }

                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    ) {
                        ThousandsSeparator(
                            "Thousands separator",
                            selectedItem = selectedValue,
                            values = valuesCollection,
                        ) { selected ->
                            selectedValue = selected
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThousandsSeparatorTheme {

    }
}