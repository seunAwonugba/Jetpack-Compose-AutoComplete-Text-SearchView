package com.example.jetpackcomposeautocompletetextview.model

import com.example.jetpackcomposeautocompletetextview.utils.AutoCompleteEntity
import java.util.*


data class Franchise(
    val name: String,
    val phoneNumber: String,
    val email: String
) : AutoCompleteEntity {
    override fun filter(query: String): Boolean {
        return name.toLowerCase(Locale.getDefault()).startsWith(query.toLowerCase(Locale.getDefault()))
    }
}