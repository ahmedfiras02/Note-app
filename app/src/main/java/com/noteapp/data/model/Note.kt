package com.noteapp.data.model

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long
)
