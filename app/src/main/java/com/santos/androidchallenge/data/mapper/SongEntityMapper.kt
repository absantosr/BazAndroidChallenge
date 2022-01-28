package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.SongEntity
import com.santos.androidchallenge.domain.model.Song

fun SongEntity.toDomain() = Song(
    id,
    readable,
    title,
    title_short,
    title_version,
    link,
    duration,
    rank,
    explicit_lyrics,
    explicit_content_lyrics,
    explicit_content_cover,
    preview,
    md5_image,
    artist,
    album,
    type
)