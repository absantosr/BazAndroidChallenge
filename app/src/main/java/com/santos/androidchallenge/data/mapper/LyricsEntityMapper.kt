package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.LyricsEntity
import com.santos.androidchallenge.domain.model.Lyrics

fun LyricsEntity.toDomain() = Lyrics(
    lyrics = lyrics
)