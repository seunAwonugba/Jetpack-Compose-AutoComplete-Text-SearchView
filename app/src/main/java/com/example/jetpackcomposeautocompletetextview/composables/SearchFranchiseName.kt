package com.example.jetpackcomposeautocompletetextview.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeautocompletetextview.model.Franchise
import com.example.jetpackcomposeautocompletetextview.utils.AutoCompleteBox
import com.example.jetpackcomposeautocompletetextview.utils.AutoCompleteSearchBarTag

@Composable
fun SearchFranchiseName(franchiseList: List<Franchise>) {
    AutoCompleteBox(
        items = franchiseList,
        itemContent = { franchise ->
            FranchiseAutoCompleteItem(franchise)
        }
    ) {
        var value by remember { mutableStateOf("") }
        val view = LocalView.current

        onItemSelected { person ->
            value = person.name
            filter(value)
            view.clearFocus()
        }

        LeadingIconSearchView(
            modifier = Modifier.testTag(AutoCompleteSearchBarTag),
            value = value,
            label = "Search with objects",
            onDoneActionClick = {
                view.clearFocus()
            },
//            onClearClick = {
//                value = ""
//                filter(value)
//                view.clearFocus()
//            },
            onFocusChanged = { focusState ->
                isSearching = focusState.isFocused
            },
            onValueChanged = { query ->
                value = query
                filter(value)
            }
        )
    }
}

@Composable
fun FranchiseAutoCompleteItem(franchise: Franchise) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row {
            Column {
                Text(text = franchise.name, style = MaterialTheme.typography.subtitle2)
                Text(text = franchise.phoneNumber, style = MaterialTheme.typography.subtitle2)
                Text(text = franchise.email, style = MaterialTheme.typography.subtitle2)
            }
        }
    }
}