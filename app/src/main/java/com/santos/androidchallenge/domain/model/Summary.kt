package com.santos.androidchallenge.domain.model

data class Summary(
    val data: List<Song>,
    val total: Int,
    val next: String
)