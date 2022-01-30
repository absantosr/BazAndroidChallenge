package com.santos.androidchallenge.data.entity

data class SummaryEntity(
    val data: List<SongEntity>,
    val total: Int,
    val next: String
)