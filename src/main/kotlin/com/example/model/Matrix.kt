package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Matrix(val rows: Int, val columns: Int)