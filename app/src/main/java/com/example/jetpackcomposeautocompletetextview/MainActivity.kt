package com.example.jetpackcomposeautocompletetextview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeautocompletetextview.composables.SearchFranchiseName
import com.example.jetpackcomposeautocompletetextview.model.Franchise
import com.example.jetpackcomposeautocompletetextview.ui.theme.JetpackComposeAutoCompleteTextViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAutoCompleteTextViewTheme {

                val franchiseList = listOf(
                    Franchise(
                        name = "Paulo Pereira",
                        phoneNumber = "08080375217",
                        email = "mayfairautos@gmail.com"
                    ),Franchise(
                        name = "Awonugba seun",
                        phoneNumber = "08080375217",
                        email = "mayfairautos@gmail.com"
                    ),Franchise(
                        name = "Oluwaseun Joseph",
                        phoneNumber = "08080375217",
                        email = "mayfairautos@gmail.com"
                    ),Franchise(
                        name = "Paulo Terry",
                        phoneNumber = "08080375217",
                        email = "mayfairautos@gmail.com"
                    )
                )
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    SearchFranchiseName(franchiseList = franchiseList)

                }
            }
        }
    }
}
