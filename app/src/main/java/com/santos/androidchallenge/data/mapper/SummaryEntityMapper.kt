package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.SummaryEntity
import com.santos.androidchallenge.domain.model.Summary

fun SummaryEntity.toDomain() = Summary(
    data = data.map { it.toDomain() },
    total = total,
    next = next
)