package com.thepourved.veterinarydictionary.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val farsiWord: String,
    val englishWord: String,
    val definition: String,
    val category: String,
    val source: String,
    val audioUrl: String? = null,
    val imageUrl: String? = null,
    val isFavorite: Boolean = false
)