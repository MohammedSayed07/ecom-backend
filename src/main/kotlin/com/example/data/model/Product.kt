package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val price: Double,
    val rating: Rating,
    val title: String
)